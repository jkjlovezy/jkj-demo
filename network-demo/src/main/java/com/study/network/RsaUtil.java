package com.study.network;


import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA公钥/私钥/签名工具类
 */
public class RsaUtil {
    /**
     * 加密算法RSA
     */
    public static final String RSA_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";

    /**
     * 生成数字签名,
     *
     * @param appKey
     * @param privateKey
     * @param timestamp  毫秒级时间戳，传System.currentTimeMillis()即可。 接口服务端会根据该参数进行1分钟失效期的校验。
     * @return
     * @throws Exception
     */
    public static String sign(String appKey, String privateKey, long timestamp) throws Exception {
        String content = String.format("appKey=%s&signType=rsa2&timestamp=%s", appKey, String.valueOf(timestamp));
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(content.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 校验数字签名
     *
     * @param data      已加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return
     */
    public static boolean verify(byte[] data, String publicKey, String sign) {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
            PublicKey publicK = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicK);
            signature.update(data);
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCH1k9kO+Ygv+mnWb51EsI5tBOG7W/QkUTywcQ0Q5fLGbL/KBzrROZs8mDl7yVHpbmJU+plyNdiIyhO9Jx5WV6lp2Gn4zmrFYhIP5WWMDUxJmlfvhJbhpEvyaqqXUIMlGmenRxXw8Yh67saVZH+sAi8manuDbOJDjHSp+lcR9LV1kF056JA05Du20PYByXB7ZC0FJB5EBQLg8i2IsAj0PSROat3SqnimZIMsRNa6i4bganNgaL2vXpre24r8eCVpZInL5l6LjlfYUU0yxBRzX5GHogoS/pucBa7lCt7WWWhvhEhNDVHq4i12/FQrV4Qpn3IAGMKAAuyzbpjOJYKMpAdAgMBAAECggEAdUySeDrlaahvy4zK0+wj/pJLPnuwz8lyYbMDjCJGZSNHF+F6v4ta8/+Fv2j4p1sr0bO+OLDrlRpJB41hxcRv39qfkMu+E8ffTIxjzzLH7C6AViYbUh/tJfgewUkQ7S4H2ulO/VbYtJgMlRwJm4ZFtR94x1HblGHGkmNfN8np/a7j0VEUgXS1XfT6UWSJ2SZHtk6/dOE2Soiy5CFIv4nn8APIaCguVNuRsvJ0vBmPQWwTQ4M4lA+uW+MK+ETldKoX57Plj1CGrDMlXUKomISFRD2HZBCx9MyzRggNSTFuurdVVDsjeMvBUk4TZS053a3aGwWBnzEAxN6qa2PHB+SIYQKBgQDiuumO+1rPLFXzluGHrAIxFs6aAz5XasbPNRAqKuPflCrrn1sz+45P3705cQgAH+hAFFf3lPwVEja7Jj1YW5P2TjbLbfZifc+j5fvrnWgEtD7Dz9gr/nuqH62Z2sqBaKLMSg+hWa+Xyd34/HZS9OgO1GxAA4kB543KE+tg48qPZQKBgQCZX4W7blvhJUW3SirhvtT27Z9k2XzXz5fKD+zAaIuzrJlRE354PIoCft0nUn0fVfERGabl/MaL2bP7tsZXrqx95e/ts9GnJ5W4ql6peCtrwGP0hd5CK2b7dWwMNGJA8O7wKXSVEeG/1Q5VPt/t2cKtbS6QB7J0eQ4n7koEQbd+WQKBgQDUz/AtnswrrUe37iUePVuJTAj8EpNPZg/ZqcrUaZGd5+spYlguwK1hV3a7FdcWltxeWToATz0VYhUxMMFf0AVfqSZRZ5Nd+w0Mn/AHxaU+1Rgcn1geYy0cD8PYp75wHRDBg7qMDix84qOQ8xb04p92W/iHVUoiGX/C71N9jBIy6QKBgGRC149xU0rZLLvnFiVAtMM/D0XEDyKdKGMFCgW10i2AlTE1ByXenXGIMVY1TGohqlc9Z6dNGRXvGQNhtkM3grdCixfexxz4eZ2gcgVi8y+bMzx0Dpk++jFDz4Ai9l/xoKEK2JVifSsEQjxjv8si4WqxxxCMl5IgWKqt0WD6/NLxAoGAElrwwn2aRQMKFBysZ+SsMPICvq6ubNCNZd2Izg7oCA+wFgWzsrCKGSVs2ZGHss/T5bwigeCEfUeaYD25FwD9ghLap93Hj3ClCnYwUDs2aEX5vHvzJnZA6rMQhBtYgeDqY+n6uTrMd9Ksn9qVMKowEjtTLVuqLkf2xaoRbJAz+Po=";
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        System.out.println(sign("20200717733725092160208896", privateKey, timestamp));
    }

}
