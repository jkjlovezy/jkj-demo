package com.study.util.mic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MIC2005EncryptHandler2 extends BaseEncryptHandler implements EncryptHandler {
    private int[] PositionMapperArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private String LongStrEncryptWheel = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private Map LongStrEncryptWheelReverseMapper = new HashMap();
    private int MIN_PLAIN_TEXT_LEN = 1;
    private int MAX_PLAIN_TEXT_LEN = 9;
    private int CIPHER_TEXT_LEN = 20;

    public MIC2005EncryptHandler2() {
    }

    public boolean isValidCipherText(String encode_long_id) {
        int[] posIndexArray = new int[this.CIPHER_TEXT_LEN];

        //int i;
        for (int i = 0; i < encode_long_id.length(); ++i) {
            char c = encode_long_id.charAt(i);
            String sC = String.valueOf(c);
            i = (Integer) this.LongStrEncryptWheelReverseMapper.get(sC);
            posIndexArray[i] = i;
        }

        int[] strUnEncryptLongArray = new int[this.CIPHER_TEXT_LEN];

        for (int i = 0; i < this.PositionMapperArray.length; ++i) {
            int index = this.PositionMapperArray[i];
            strUnEncryptLongArray[i] = posIndexArray[index];
        }

        long lSum = 0L;

        for (int i = 1; i < strUnEncryptLongArray.length; ++i) {
            int index = strUnEncryptLongArray[i];
            lSum += (long) (index % 10);
        }

        lSum %= (long) this.LongStrEncryptWheel.length();
        long oldSum = (long) strUnEncryptLongArray[0];
        return oldSum == lSum;
    }

    public String encode(long long_id) throws RuntimeException, IllegalStateException {
        this.checkStatus();
        String sLongID = String.valueOf(long_id);
        if (sLongID.length() <= this.MAX_PLAIN_TEXT_LEN && sLongID.length() >= this.MIN_PLAIN_TEXT_LEN) {
            StringBuffer sb = new StringBuffer(this.CIPHER_TEXT_LEN);

            for (int i = 0; i < this.MAX_PLAIN_TEXT_LEN - sLongID.length(); ++i) {
                sb.append('0');
            }

            sb.append(sLongID);
            this.genRandomNumline(long_id, this.CIPHER_TEXT_LEN - sb.length() - 1, sb);
            StringBuffer strWholeLongUnEncrypt = sb;
            sb.insert(0, '0');
            int[] strLongUnEncryptedArray = new int[this.CIPHER_TEXT_LEN];
            Random rand = new Random(long_id);
            Set encryptSet = new HashSet(this.CIPHER_TEXT_LEN * 2);

            int l;
            for (int i = 0; i < strWholeLongUnEncrypt.length(); ++i) {
                char c = strWholeLongUnEncrypt.charAt(i);
                l = 2147483647;
                Integer sL = null;
                int randNum;
                int randNumCount;
                if (i == 0) {
                    randNum = 0;

                    for (randNumCount = 0; randNumCount < strWholeLongUnEncrypt.length(); ++randNumCount) {
                        char c1 = strWholeLongUnEncrypt.charAt(randNumCount);
                        int lDiff = c1 - 48;
                        randNum += lDiff;
                    }

                    l = randNum % this.LongStrEncryptWheel.length();
                } else {
                    label84:
                    while (true) {
                        do {
                            if (l <= this.LongStrEncryptWheel.length() - 1) {
                                break label84;
                            }

                            randNum = Math.abs(rand.nextInt());

                            for (randNumCount = 0; randNum < 0 && randNumCount < 10; randNum = Math.abs(rand.nextInt())) {
                                ++randNumCount;
                            }

                            if (randNumCount >= 10) {
                                randNum = 1000;
                            }

                            l = randNum % (this.LongStrEncryptWheel.length() / 10 + 1);
                            l = l * 10 + (c - 48);
                            sL = new Integer(l);
                        } while (!encryptSet.contains(sL));

                        for (int j = 0; j < 10; ++j) {
                            randNum = Math.abs(rand.nextInt());
                            l = randNum % (this.LongStrEncryptWheel.length() / 10 + 1);
                            l = l * 10 + (c - 48);
                            sL = new Integer(l);
                            if (!encryptSet.contains(sL)) {
                                break;
                            }
                        }
                    }
                }

                encryptSet.add(sL);
                strLongUnEncryptedArray[i] = l;
            }

            int[] strLongUnEncryptConfusedArray = new int[this.CIPHER_TEXT_LEN];

            int index;
            for (int i = 0; i < strLongUnEncryptedArray.length; ++i) {
                l = strLongUnEncryptedArray[i];
                index = this.PositionMapperArray[i];
                strLongUnEncryptConfusedArray[index] = l;
            }

            char[] encryptArray = new char[strLongUnEncryptConfusedArray.length];

            for (l = 0; l < strLongUnEncryptConfusedArray.length; ++l) {
                index = strLongUnEncryptConfusedArray[l];
                encryptArray[l] = this.LongStrEncryptWheel.charAt(index);
            }

            return new String(encryptArray);
        } else {
            throw new RuntimeException("Invalid ID! id=" + long_id);
        }
    }

    public long decode(String anString) throws RuntimeException, IllegalStateException {
        this.checkStatus();
        String encode_long_id = anString;
        int[] posIndexArray = new int[this.CIPHER_TEXT_LEN];

        int val;
        for(int i = 0; i < encode_long_id.length(); ++i) {
            char c = encode_long_id.charAt(i);
            String sC = String.valueOf(c);
            val = (Integer)this.LongStrEncryptWheelReverseMapper.get(sC);
            posIndexArray[i] = val;
        }

        int[] strUnEncryptLongArray = new int[this.CIPHER_TEXT_LEN];

        for(int i = 0; i < this.PositionMapperArray.length; ++i) {
            int index = this.PositionMapperArray[i];
            strUnEncryptLongArray[i] = posIndexArray[index];
        }

        long lSum = 0L;

        for(int i = 1; i < strUnEncryptLongArray.length; ++i) {
            int index = strUnEncryptLongArray[i];
            lSum += (long)(index % 10);
        }

        lSum %= (long)this.LongStrEncryptWheel.length();
        long oldSum = (long)strUnEncryptLongArray[0];
        if (oldSum != lSum) {
            throw new RuntimeException("IllegalCiphertext! Cipher Text is:" + encode_long_id);
        } else {
            long l = 0L;

            for(int i = 0; i < strUnEncryptLongArray.length; ++i) {
                int digital = strUnEncryptLongArray[i];
                digital %= 10;
                l = l * 10L + (long)digital;
            }

            long l2 = Math.round(Math.pow(10.0D, (double)this.MAX_PLAIN_TEXT_LEN));
            l %= l2;
            return l;
        }
    }

    public void setPlainTextAndCipherTextLength(int lenPlainText, int lenCipherText) throws IllegalArgumentException {
        this.MAX_PLAIN_TEXT_LEN = lenPlainText;
        this.CIPHER_TEXT_LEN = lenCipherText;
    }

    public void setPositionMangleTable(String[] table) throws IllegalArgumentException {
        this.PositionMapperArray = new int[table.length];

        for (int i = 0; i < table.length; ++i) {
            this.PositionMapperArray[i] = Integer.parseInt(table[i]);
        }

    }

    public void setEncryptionTable(String table) throws IllegalArgumentException {
        this.LongStrEncryptWheel = table;

        for (int i = 0; i < this.LongStrEncryptWheel.length(); ++i) {
            char c = this.LongStrEncryptWheel.charAt(i);
            this.LongStrEncryptWheelReverseMapper.put(String.valueOf(c), new Integer(i));
        }

    }

    public String encryptText(String unencodeText) throws IllegalArgumentException {
        String oriTable = "1234567890abcdefghijklmnopqrstuvwxyz";
        String encodeTable = "ijklnoqpmrwygxzsefhacdb3412657890vtu";
        String symbol = "~!@#$%^&*()`[];'-_\"\\,./{}:|<>?";
        String symbolTable = "ABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZABK";
        String encodedText = "";
        unencodeText = unencodeText.toLowerCase();
        String newString = "";
        newString = newString + unencodeText.substring(1, unencodeText.length());
        newString = newString + unencodeText.charAt(0);
        unencodeText = newString;
        newString = "";
        int specCode = 0;

        for (int i = 0; i < unencodeText.length(); ++i) {
            specCode += unencodeText.substring(i, i + 1).hashCode();
        }

        String specString = String.valueOf(specCode);
        if (specString.length() > 1) {
            specString = specString.substring(specString.length() - 1, specString.length()) + specString.substring(1, specString.length() - 1) + specString.substring(0, 1);
        }

        unencodeText = specString + "|" + unencodeText;

        int i;
        char c2;
        int postion;
        for (i = 0; i < unencodeText.length(); ++i) {
            c2 = unencodeText.charAt(i);
            postion = oriTable.indexOf(c2);
            if (postion >= 0) {
                char newChar = encodeTable.charAt(postion);
                encodedText = encodedText + newChar;
            } else {
                encodedText = encodedText + c2;
            }
        }

        unencodeText = encodedText;
        encodedText = "";

        for (i = 0; i < unencodeText.length(); ++i) {
            c2 = unencodeText.charAt(i);
            postion = symbol.indexOf(c2);
            if (postion >= 0) {
                String newChar = symbolTable.substring(postion * 2, postion * 2 + 2);
                encodedText = encodedText + newChar;
            } else {
                encodedText = encodedText + c2;
            }
        }

        newString = "";

        for (i = 0; i < encodedText.length(); i += 2) {
            if (encodedText.length() > i + 1) {
                c2 = encodedText.charAt(i + 1);
                newString = newString + c2;
                char c1 = encodedText.charAt(i);
                newString = newString + c1;
            } else {
                c2 = encodedText.charAt(i);
                newString = newString + c2;
            }
        }

        encodedText = newString;
        newString = "";
        newString = newString + encodedText.charAt(encodedText.length() - 1);
        newString = newString + encodedText.substring(1, encodedText.length() - 1);
        newString = newString + encodedText.charAt(0);
        return newString;
    }

    public String decryptText(String encodeText) throws IllegalArgumentException {
        String oriTable = "1234567890abcdefghijklmnopqrstuvwxyz";
        String encodeTable = "ijklnoqpmrwygxzsefhacdb3412657890vtu";
        String symbol = "~!@#$%^&*()`[];'-_\"\\,./{}:|<>?";
        String symbolTable = "ABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZABK";
        String decodedText = "";
        decodedText = decodedText + encodeText.charAt(encodeText.length() - 1);
        decodedText = decodedText + encodeText.substring(1, encodeText.length() - 1);
        decodedText = decodedText + encodeText.charAt(0);
        encodeText = decodedText;
        decodedText = "";

        int i;
        char c;
        for (i = 0; i < encodeText.length(); i += 2) {
            if (encodeText.length() > i + 1) {
                c = encodeText.charAt(i + 1);
                decodedText = decodedText + c;
                char c1 = encodeText.charAt(i);
                decodedText = decodedText + c1;
            } else {
                c = encodeText.charAt(i);
                decodedText = decodedText + c;
            }
        }

        String specString;
        int specCodeUnCheck;
        for (i = 0; i < symbolTable.length(); i += 2) {
            String sym = symbolTable.substring(i, i + 2);
            specCodeUnCheck = decodedText.indexOf(sym);
            if (specCodeUnCheck >= 0) {
                specString = symbol.substring(i / 2, i / 2 + 1);
                decodedText = decodedText.replaceAll(sym, specString);
            }
        }

        encodeText = decodedText;
        decodedText = "";

        for (i = 0; i < encodeText.length(); ++i) {
            c = encodeText.charAt(i);
            specCodeUnCheck = encodeTable.indexOf(c);
            if (specCodeUnCheck >= 0) {
                char newChar = oriTable.charAt(specCodeUnCheck);
                decodedText = decodedText + newChar;
            } else {
                decodedText = decodedText + c;
            }
        }

        String[] tmpArray = decodedText.split("\\|", 2);
        int specCode = Integer.valueOf(tmpArray[0]);
        decodedText = tmpArray[1];
        specCodeUnCheck = 0;

        for (i = 0; i < decodedText.length(); ++i) {
            specCodeUnCheck += decodedText.substring(i, i + 1).hashCode();
        }

        specString = String.valueOf(specCodeUnCheck);
        if (specString.length() > 1) {
            specString = specString.substring(specString.length() - 1, specString.length()) + specString.substring(1, specString.length() - 1) + specString.substring(0, 1);
        }

        specCodeUnCheck = Integer.valueOf(specString);
        if (specCodeUnCheck != specCode) {
            throw new IllegalArgumentException("输入参数不合法");
        } else {
            String newString = "";
            newString = newString + decodedText.charAt(decodedText.length() - 1);
            newString = newString + decodedText.substring(0, decodedText.length() - 1);
            return newString;
        }
    }

    private StringBuffer genRandomNumline(long lSeed, int len, StringBuffer sbResult) {
        Random rand = new Random(lSeed);

        for (int i = 0; i < len; ++i) {
            int l = Math.abs(rand.nextInt());
            l %= 10;
            sbResult.insert(0, (char) (l + 48));
        }

        return sbResult;
    }

    private void checkStatus() throws IllegalStateException {
        if (this.MAX_PLAIN_TEXT_LEN >= this.CIPHER_TEXT_LEN) {
            throw new IllegalStateException();
        } else if (this.CIPHER_TEXT_LEN != this.PositionMapperArray.length) {
            throw new IllegalStateException();
        } else if (this.LongStrEncryptWheelReverseMapper.size() < 9) {
            throw new IllegalStateException();
        }
    }
}
