package com.study.util.jasypt;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.text.BasicTextEncryptor;

public class JaspterHelper {
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
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("encrypt fail");
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
        } catch (EncryptionOperationNotPossibleException e) {
            e.printStackTrace();
            throw new RuntimeException("decrypt fail");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("decrypt fail");
        }
    }

    public static String textEncryptor2(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return null;
        }
        try {
            return signInInfoEncryptor.encrypt(encryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("encrypt fail");
        }
    }

    public static String textDecryptor2(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return null;
        }
        try {
            return signInInfoEncryptor.decrypt(encryptedMessage);
        } catch (EncryptionOperationNotPossibleException e) {
            e.printStackTrace();
            throw new RuntimeException("decrypt fail");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("decrypt fail");
        }
    }

}
