package com.study.util.mic;

public interface EncryptHandler {
    boolean isValidCipherText(String var1);

    String encode(long var1);

    long decode(String var1);

    void setPlainTextAndCipherTextLength(int var1, int var2) throws IllegalArgumentException;

    void setPositionMangleTable(String[] var1) throws IllegalArgumentException;

    void setEncryptionTable(String var1) throws IllegalArgumentException;
}
