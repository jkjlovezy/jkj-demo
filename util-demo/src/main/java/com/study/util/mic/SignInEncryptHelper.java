package com.study.util.mic;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * 提供登录Cookie信息等加密服务,需要配置到所有Site->Spring-login.xml中（此类不要乱用，目前只提供给‘登录Cookie信息’加密）
 * <p>
 * Created by wangjinping on 2017/5/18.
 * </p>
 */
@Slf4j
public class SignInEncryptHelper {

    private static BasicTextEncryptor signInInfoEncryptor;

    static {
        signInInfoEncryptor = new BasicTextEncryptor();
        signInInfoEncryptor.setPassword("crov1234");
    }

    /**
     * 加密
     *
     * @param encryptedMessage
     * @return
     */
    public static String textEncryptor(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return null;
        }
        try {
            return new String(
                    Base64.encodeBase64String(signInInfoEncryptor.encrypt(encryptedMessage).getBytes("UTF-8")));
        }
        catch (Exception exception) {
            log.error("textEncryptorGenerate exception!", exception);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param encryptedMessage
     * @return
     */
    public static String textDecryptor(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return null;
        }
        try {
            return signInInfoEncryptor.decrypt(new String(Base64.decodeBase64(encryptedMessage), "UTF-8"));
        }
        catch (EncryptionOperationNotPossibleException exception) {
            log.warn("信息：textEncryptorGenerate exception！EncryptionOperationNotPossibleException",
                    exception);
            return null;
        }
        catch (Exception exception) {
            log.error("textEncryptorGenerate exception!", exception);
            return null;
        }
    }

    public BasicTextEncryptor getSignInInfoEncryptor() {
        return signInInfoEncryptor;
    }

    public void setSignInInfoEncryptor(BasicTextEncryptor signInInfoEncryptor) {
        this.signInInfoEncryptor = signInInfoEncryptor;
    }
}
