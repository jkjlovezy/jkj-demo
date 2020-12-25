package com.study.util.mic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.study.util.ip.Constants;

public class EncryptComponentImpl implements EncryptComponent {

    public final static Log log = LogFactory.getLog(EncryptComponentImpl.class);
    // 正常ID加解密
    private EncryptHandler encryptHandler;
    // 图片ID加解密
    @Deprecated // 不再区分图片和普通的Id，使用统一的接口
    private EncryptHandler encryptHandler4Image;
    // 加密和解密处理类
    private String encryptHandlerClass;
    // ID最小长度
    private Integer unEncryptMinLen;
    // ID最大长度
    private Integer unEncryptMaxLen;
    // 加密后的长度
    private Integer encryptLen;
    // 待加密的值包含的值
    private String encryptPosMap;
    private String encryptWheelMap;
    @Deprecated // 不再区分图片和普通的Id，使用统一的接口
    private String encryptPosMap4Image;
    @Deprecated // 不再区分图片和普通的Id，使用统一的接口
    private String encryptWheelMap4Image;

    //
    private MIC2005EncryptHandler2 textEncryptHandler;

    /**
     * 解密
     */
    @Override
    public Long decode(String idEncrypt) {
        try {
            if (StringUtils.isBlank(idEncrypt)) {
                return null;
            } else {
                return encryptHandler.decode(StringUtils.trimToEmpty(idEncrypt));
            }
        } catch (Exception e) {
            log.warn("decode(String idEncrypt) wrong idEncrypt=" + idEncrypt + " encryptHandler=" + encryptHandler, e);
            return null;
        }
    }

    /**
     * 加密
     */
    @Override
    public String encode(Long id) {
        try {
            return (id == null) ? null : encryptHandler.encode(id);
        } catch (Exception e) {
            log.warn("encode(Long id) wrong id=" + id + " encryptHandler=" + encryptHandler, e);
            return null;
        }
    }

    @Override
    public String decodeText(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        try {
            return textEncryptHandler.decryptText(str);
        } catch (Throwable t) {
            log.warn("decodeText(String str) wrong str=" + str + " textEncryptHandler=" + textEncryptHandler, t);
        }
        return null;
    }

    @Override
    public String encodeText(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        try {
            return textEncryptHandler.encryptText(str);
        } catch (Throwable t) {
            log.warn("encodeText(String str) wrong str=" + str + " textEncryptHandler=" + textEncryptHandler, t);
        }
        return null;
    }

    public String getEncryptHandlerClass() {
        return encryptHandlerClass;
    }

    public Integer getEncryptLen() {
        return encryptLen;
    }

    public String getEncryptPosMap() {
        return encryptPosMap;
    }

    public String getEncryptPosMap4Image() {
        return encryptPosMap4Image;
    }

    public String getEncryptWheelMap() {
        return encryptWheelMap;
    }

    public String getEncryptWheelMap4Image() {
        return encryptWheelMap4Image;
    }

    public Integer getUnEncryptMaxLen() {
        return unEncryptMaxLen;
    }

    public Integer getUnEncryptMinLen() {
        return unEncryptMinLen;
    }

    /**
     * 完成加密器和解密器的初始化
     *
     * @throws Exception
     */
    public void initialize() throws Exception {
        Class<?> clsHandler = Class.forName(getEncryptHandlerClass());
        encryptHandler = (EncryptHandler) clsHandler.newInstance();
        encryptHandler.setPlainTextAndCipherTextLength(getUnEncryptMaxLen(), getEncryptLen());
        encryptHandler.setPositionMangleTable(StringUtils.split(getEncryptPosMap(), Constants.SEP_COMMA));
        encryptHandler.setEncryptionTable(getEncryptWheelMap());
        //
        if (encryptHandler instanceof MIC2005EncryptHandler2) {
            textEncryptHandler = (MIC2005EncryptHandler2) encryptHandler;
        }
    }

    public void setEncryptHandlerClass(String encryptHandlerClass) {
        this.encryptHandlerClass = encryptHandlerClass;
    }

    public void setEncryptLen(Integer encryptLen) {
        this.encryptLen = encryptLen;
    }

    public void setEncryptPosMap(String encryptPosMap) {
        this.encryptPosMap = encryptPosMap;
    }

    public void setEncryptPosMap4Image(String encryptPosMap4Image) {
        this.encryptPosMap4Image = encryptPosMap4Image;
    }

    public void setEncryptWheelMap(String encryptWheelMap) {
        this.encryptWheelMap = encryptWheelMap;
    }

    public void setEncryptWheelMap4Image(String encryptWheelMap4Image) {
        this.encryptWheelMap4Image = encryptWheelMap4Image;
    }

    public void setUnEncryptMaxLen(Integer unEncryptMaxLen) {
        this.unEncryptMaxLen = unEncryptMaxLen;
    }

    public void setUnEncryptMinLen(Integer unEncryptMinLen) {
        this.unEncryptMinLen = unEncryptMinLen;
    }

}
