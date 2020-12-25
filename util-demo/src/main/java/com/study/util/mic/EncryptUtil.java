package com.study.util.mic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncryptUtil {

    static final Log log = LogFactory.getLog(EncryptUtil.class);

    static EncryptComponentImpl encryptComponent;

    static {

        //String encrypthandlerclass = "com.focustech.utils.encrypt.MIC2005EncryptHandler2";
        String encrypthandlerclass = "com.study.util.mic.MIC2005EncryptHandler2";
        String encryptposmap = "0,1,2,3,4,5,6,7,8,9,10,11";
        String encryptwheelmap = "ABCDEFGHIJKLMNOPQRSTUVWYZabcdefghijklmnopqrstuvwyz";
        int unencryptminlen = 1;
        int unencryptmaxlen = 10;
        int encryptlen = 12;
        encryptComponent = new EncryptComponentImpl();
        encryptComponent.setEncryptHandlerClass(encrypthandlerclass);
        encryptComponent.setEncryptPosMap(encryptposmap);
        encryptComponent.setEncryptWheelMap(encryptwheelmap);
        encryptComponent.setUnEncryptMinLen(1);
        encryptComponent.setUnEncryptMaxLen(10);
        encryptComponent.setEncryptLen(12);
        try {
            encryptComponent.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 对加密字符串进行解密，返回long型 Create Time: 2005-12-13 23:12:52
     *
     * @author JimCheng/成俊杰
     */
    final public static Long decode(String idEncrypt) {
        return encryptComponent.decode(idEncrypt);
    }

    /**
     * 解密后返回字符串
     *
     * @param idEncrypt
     * @return
     */
    final public static String decode2Str(String idEncrypt) {
        if (NumberUtils.isCreatable(idEncrypt)) {
            return idEncrypt;
        }
        Long decodeId = encryptComponent.decode(idEncrypt);
        return decodeId == null ? null : String.valueOf(decodeId);
    }

    /**
     * @param str
     * @param splitStr
     * @return
     */
    public static String[] decodeMulti2Array(String str, String splitStr) {
        return (String[]) decodeMulti2List(str, splitStr).toArray();
    }

    /**
     * @param strs
     * @return
     */
    public static String[] decodeMulti2Array(String[] strs) {
        String[] result = null;
        if ((strs != null) && (strs.length != 0)) {
            result = new String[strs.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = decode2Str(strs[i]);
            }
        }
        return result;
    }

    /**
     * 解密ID 的List
     *
     * @param strs
     * @return
     */
    public static List<String> decodeMulti2List(List<String> strs) {
        List<String> decodeIdList = null;
        if ((strs != null) && (strs.size() > 0)) {
            decodeIdList = new ArrayList<String>();
            for (String encodeId : strs) {
                decodeIdList.add(decode2Str(encodeId));
            }
        }
        return decodeIdList;
    }

    /**
     * @param str
     * @param splitStr
     * @return
     */
    public static List<String> decodeMulti2List(String str, String splitStr) {
        List<String> result = new ArrayList<String>();
        if (!StringUtils.isBlank(str)) {
            String[] strArray = StringUtils.split(str, splitStr);
            for (int i = 0; i < strArray.length; i++) {
                String decodeStr = decode2Str(strArray[i]);
                if ((decodeStr != null) && !"".equals(decodeStr)) {
                    result.add(decodeStr);
                }
            }
        }
        return result;
    }

    public static List<Long> decodeMulti2LongList(String str, String splitStr) {
        List<Long> result = new ArrayList<Long>();
        if (!StringUtils.isBlank(str)) {
            String[] strArray = StringUtils.split(str, splitStr);
            for (int i = 0; i < strArray.length; i++) {
                String decodeStr = decode2Str(strArray[i]);
                if ((decodeStr != null) && !"".equals(decodeStr)) {
                    result.add(Long.valueOf(decodeStr));
                }
            }
        }
        return result;
    }

    public static List<Long> decodeMulti2LongList(List<String> strs) {
        List<Long> decodeIdList = new ArrayList<Long>();
        if ((strs != null) && (strs.size() > 0)) {
            for (String encodeId : strs) {
                String decodeStr = decode2Str(encodeId);
                if ((decodeStr != null) && !"".equals(decodeStr)) {
                    decodeIdList.add(Long.valueOf(decodeStr));
                }
            }
        }
        return decodeIdList;
    }

    /**
     * @param str
     * @param splitStr
     * @return
     */
    public static String decodeMulti2Str(String str, String splitStr) {
        if (StringUtils.isBlank(str)) {
            return str;
        } else {
            StringBuffer sb = new StringBuffer();
            String[] strArray = StringUtils.split(str, splitStr);
            for (int i = 0; i < strArray.length; i++) {
                String decodeStr = decode2Str(strArray[i]);
                if ((decodeStr != null) && !"".equals(decodeStr)) {
                    sb.append(splitStr).append(decodeStr);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
    }

    /**
     * @param long_id
     * @return
     */
    final public static String encode(Long long_id) {
        return encryptComponent.encode(long_id);
    }

    /**
     * @param id
     * @return
     */
    final public static String encode(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        } else {
            return encryptComponent.encode(new Long(id));
        }
    }

    /**
     * @param strs
     * @return
     */
    public static String[] encodeMulti2Array(String[] strs) {
        String[] result = null;
        if ((strs != null) && (strs.length != 0)) {
            result = new String[strs.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = encode(strs[i]);
            }
        }
        return result;
    }

    /**
     * @param strIds
     * @param split
     * @return
     */
    public static String encodeMulti2Str(String strIds, String split) {
        if ((strIds == null) || "".equals(strIds)) {
            return strIds;
        } else {
            StringBuffer sb = new StringBuffer();
            String[] arrayIds = StringUtils.split(strIds, split);
            for (int i = 0; i < arrayIds.length; i++) {
                sb.append(split).append(encode(arrayIds[i]));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
    }

    /**
     *
     */
    public String decode(String val, String defaultVal) {
        try {
            if (StringUtils.isBlank(val)) {
                return defaultVal;
            } else {
                return String.valueOf(decode(val));
            }
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public String encode(String val, String defaultVal) {
        try {
            if (StringUtils.isBlank(val)) {
                return defaultVal;
            } else {
                return encode(new Long(val));
            }
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public static String encodeText(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return encryptComponent.encodeText(str);

    }

    public static String decodeText(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return encryptComponent.decodeText(str);
    }

}
