package com.study.util.encrypt;

import org.apache.commons.lang3.StringUtils;

import com.focustech.silk.commons.components.constans.Constants;
import com.focustech.utils.encrypt.EncryptHandler;
import com.focustech.utils.encrypt.IllegalCiphertextException;
import com.focustech.utils.encrypt.IllegalPlaintextException;

public class MicEncryptTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalPlaintextException, IllegalCiphertextException {
        String encrypthandlerclass="com.focustech.utils.encrypt.MIC2005EncryptHandler2";
        String encryptposmap="0,1,2,3,4,5,6,7,8,9,10,11";
        String  encryptwheelmap="ABCDEFGHIJKLMNOPQRSTUVWYZabcdefghijklmnopqrstuvwyz";
        int unencryptminlen=1;
        int unencryptmaxlen=10;
        int encryptlen=12;
        Class<?> clsHandler = Class.forName(encrypthandlerclass);

        EncryptHandler encryptHandler = (EncryptHandler) clsHandler.newInstance();
        encryptHandler.setPlainTextAndCipherTextLength(unencryptmaxlen, encryptlen);
        encryptHandler.setPositionMangleTable(StringUtils.split(encryptposmap, Constants.SEP_COMMA));
        encryptHandler.setEncryptionTable(encryptwheelmap);

        String encryptId = encryptHandler.encode(1234567890L);
        System.out.println(encryptId);
        Long id = encryptHandler.decode(encryptId);
        System.out.println(id);
    }
}
