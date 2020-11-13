package com.study.network;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class OkHttpTest {

    public static void main(String[] args) throws Exception {

//            placeOrder();
        externRegisterGet();

    }

    public static void externRegisterGet() throws Exception {
        String appKey = "20201028771070396366585856";
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDEvH6fqBUO5qdhyj5VwE3zUv0fx+aLpJIa2SSRY+PmsLPJ/6AFim3pbQj1TpMU8+tbHx84heXxOqkwOkZQaXTkGXeUFOKbAht49a01HF71CN3z+mJPAPA7JbqoemYuVvKzBuO6xfUvQBO/5Vrpi16Nc/3ULiW0mzwFQGX2QQDA+i+krfx2X3jcvqvNPVN9WLbOJFDRktF6QnMGnqNreSVaLxLZfwjqIzj5TCJ5RJPdDc+PdPmKi59Ume5CjnzAU3AGeDbV6rSHltdqhEa/7DlA/HEyubS/HuYm7+yZUcAGbHUs7Ak3GpLhu+tpAG1l35jlsrnd72rZzWKMgZS3bKeTAgMBAAECggEAD+j+hILfURkuKCZm7CBlLWxktBFCf8CLYEh3QJrHb3ySzZ8yncAYK2x58PytwGAJhJD7wWJyuhN4Y0ITNaWRonC8zujxen+tIRcdLtJgi4hwCq8RDDqTMvVWJxHe+ZhmgDvqZsxji7Ku5jHyLDjtKJtcx7ADtJtpOzN+C3AuU2zD6M8x0ZnbmHEb3B0MBOnfqUY1BP+4VR1r9kTUnZYTaRNVGDeCtTlcYb/FdrtWMNCJdoLmBjSmmidcnh7CXrwoXPRxDsMvlaKNHvCijI2opnTqSRk5KMYDQ1Ywi7GFCYSR9LwGz68CSpFZ2X40edm7DGT25NW/YMXM+TaVMKLFIQKBgQDieO1DDlXE+5fxfNduclDm5E4/vknbYJh9I2gL7e2IJt+HiUbzQUX9NT2L44dTbJ/7xyb5N5xdRqW9qF4M2buFFbvTj384o2gpChUvPe7I9QT6Ya6a1y3q5f/eK107GSkb7s8K9x7Y9NcMSTGq5/aylnH60Hsa24yJ3Yo7f4ULHwKBgQDeYw2v5pq+ZRP42rDaUm0GcGlfjlKOsaIuIDqCgdvwtQOCQR6iFgXsNRN02Iznv+YV58eyNvvHCf6usfvcaUXZHI4dLd7ooKZWM7fb8UR7HFyrRZI8x7c17G+UOzwp+PiaSmH9fbjH9A9baZw8yh7C2ZbCDpUlwJArnfxBfdkJDQKBgFtianLtfOSQlT5HnvKdRFH2/DAyi8DvGHkeaWSu7HNNJFOfrDaKN0C2VBB3jmq2YVQKh4p2yyzETiranqDW1xkbrP/wXmivX194BxZaClmirRCPjBJFE+0+Q+IVY3huba0szvTgxNzM5124x0bsdRqZJIMNzy8GOo6DC714dmoHAoGAdWUMwKKXZZKuLFwlp9qDOzb0KUFUS4dx+a+Bs4shs7uakpQVu7KshbivAKugFmay6zVjsaxc1QFttIK4Ve4stSPh0X15govrwu2iTTTb1bFvKeqb/AHhsVGSxUlPxUhs0+YYPFy1wrgPs03Y8C4yduGuN9rC2R8B/ER1+YyZmbECgYAXePilWrXQZNvkak4JPyiFECz9hyOaoUS0AV9CxKJuuTARPSXdqRQsjiHGWb0Ntxoy38VtN6GcHI+9jVJ/NWrANsfzeVjULJwY4PXztJamdpwUDLDLeINCOGtZXghFJllBGZ7tBx6t6OOs2BOl5Xswdaoq78YA4GH9OmxbS7ZxQQ==";
        Long timestamp = System.currentTimeMillis();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(getSSLSocketFactory(), getX509TrustManager())
                .hostnameVerifier(getHostnameVerifier())
                .build();
        RequestBody body = new FormBody.Builder().add("micComId", "VIUKoAeyhszF").build();
        Request request = new Request.Builder()
                .url("https://open.made-in-china.com/apis/com/externRegister/get")
                //.url("http://open.made-in-china.com/apis/com/externRegister/get")
                .header("appKey", "20201028771070396366585856")
                .header("signType", "rsa2")
                .header("timestamp", timestamp.toString())
                .header("sign", RsaUtil.sign(appKey, privateKey, timestamp))
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("request: " + request.toString());
        System.out.println("response: " + response.body().string());
    }

    private static SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, getTrustManager(), new SecureRandom());
        return sslContext.getSocketFactory();
    }

    private static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        return hostnameVerifier;
    }

    private static TrustManager[] getTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
        return trustAllCerts;
    }

    private static X509TrustManager getX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        };
    }

    public static void placeOrder() throws IOException {
        String json = "{\"platformBusiId\":120020429,\"platformUserId\":120011173,\"bBusiId\":120020429,\"billingAddress\":{\"countryId\":121991,\"provinceId\":122001,\"city\":\"122061\",\"addr1\":\"few124\",\"addr2\":\"afsd32\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"goodsItems\":[{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728823664,\"goodsId\":728823664,\"goodsName\":\"Car 029\",\"goodsSkuPicId\":0,\"goodsSkuPicUrl\":\"\",\"goodsSkuType\":\"1\",\"goodsQuantity\":500,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":9000,\"goodsCost\":4500000.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0},{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728823644,\"goodsId\":728823644,\"goodsName\":\"Car 027\",\"goodsSkuPicId\":0,\"goodsSkuPicUrl\":\"\",\"goodsSkuType\":\"1\",\"goodsQuantity\":300,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":5245,\"goodsCost\":1573500.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0},{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728692914,\"goodsId\":728692914,\"goodsName\":\"Qwert Ert Ewrt<Marquee> Adfadfmaklsdvasd</Marquee>Ss\",\"goodsSkuPicId\":674344364,\"goodsSkuPicUrl\":\"//image.made-in-china.com/3f2j00qAfGmtYjENlZ/Qwert-Ert-Ewrt-Marquee-Adfadfmaklsdvasd-Marquee-Ss.jpg\",\"goodsSkuType\":\"1\",\"goodsQuantity\":100,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":500,\"goodsCost\":50000.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0}],\"deliveryDeadLine\":\"2020-11-04 11:21:19\",\"totalTax\":0,\"totalFreight\":0}";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url("http://openapi.innercrov.com/api/order/mic/placeOrder")
                .header("appKey", "20201016766612537612435456")
                .header("userId", "120011173")
                .header("comId", "120020429").post(body).build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void queryWithdrawList() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://192.168.23.225:8888/api/account/mic/withdraw/queryWithdrawList?pageSize=5&beginTime=2020-09-20 20:32:45&endTime=2020-10-22%2021:33:45&pageNum=1")
                .header("appKey", "20201016766612537612435456")
                .header("userId", "622186514")
                .header("comId", "614823684").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code() + "\t" + response.body().string());
    }
}
