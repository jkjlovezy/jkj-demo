package com.study.util.mic;

public interface EncryptComponent {

    /**
     * 解密ID
     *
     * @param idEncrypt
     * @return
     */
    Long decode(String idEncrypt);

    /**
     * 加密ID
     *
     * @param id
     * @return
     */
    String encode(Long id);

    /**
     * @param str
     * @return
     */
    String decodeText(String str);

    /**
     * @param str
     * @return
     */
    String encodeText(String str);
}
