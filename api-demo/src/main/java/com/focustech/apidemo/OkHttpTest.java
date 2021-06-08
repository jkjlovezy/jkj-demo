package com.focustech.apidemo;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class OkHttpTest {

    static String appKey = "20201104773558258693570560";
    static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCm8p85smNCGgKEXpfFnM1hlOnzbmm3wCgusR8wQ4dbhLZsdCsPlF6iuz8dMkRVpTcbmaVK7Z4RH2K6tcKE+6rBabFgbqDcQG5o4r5eCNEq68ee5AdmGvszXfsW5wwxIULvWAGywk8nqwtnNproN3PkcUtIDvgAvpsZCsaZaS/9nYEJMGsdX36PbT+2cCFC/40YACL9vFhD25opDx0a3GqxazZCjjSIRDmPc4iXP+1mhco5v/lA+Bre0vNFXG4N2+eWFdyFivttvRz/uBC3s6PQEvE3tl96g+Okye1smfsP+c4tVS8WAGS2oF5FQi4i0RP/+oZ/tx3rtw5jLJF7clfAgMBAAECggEAXJ2u6/0YBXtlk2YreYxI7Dax0bdvo+ZU4qUuOi0IHlR054xRJiMW0if7v1XtUu8rplhfQ/54aTZgNActsAbMYtgiF8JTiWu0RnizTw4jLEn2Z05FtsbkGUrmdGPOEUL5+YYztv15MlRuUfX9aP7s64k54jMOYl6aSAyMCC71se1GF64VieQng4zUfhvt3I3gKE37A4wRjMPZaTGyEEvESRoKqmBcpbPCCeodKwa0DxuKuTPL1MhIBztq8Xo5u+magyA0sFch+61xCMhKkGNlI5EcMlSxOFIo1SlGGYPQCCfyBInEMd9qURiL42UG8g/1Dsq2mSFRwKd1hSOswMEWIQKBgQDHf410fca1h+37ebLD7eqFMq/JFxHO5yEWzlEejPK98LWoe89BJ/IUHebhMtecBzc5mo7Pt/WgAbpf0A0+ZnofCyeV5mRRDMhFczKXEYuRJjjV32KLBHWk3uWB+dfkQzdoFO3M6fITJwXsZ9AYpmu1Fi8uXY6V6tcAhAkVCC/dTwKBgQCnmXN2JO3CovjnX7Pimo78F9k8ux4vuxhjX9m+teaYTOLlyKW8CLsBfRuswoy8wus5w/ZLjOjmJZJOq2qCxjMvVQtU8O1DYJotmv9ri8EPulWXBzAJi6n8nh3Lh4AkozXz00MDIiA8XV8DS1uQrDy6CjS9R4OW3B2tr+ZZuzHu8QKBgQCiobb9SjOddQxqv1EeLGvM3f8znVzlIMJ2xwaWMy0H7p0IlrXkVd4gzCeVWk8uYSuCCB938m2IXSBET2Ucg4n2mK9SohkRgawaAckyIhl24IPgxlSdI6uMFjFe/gAjkzAt5zHcpLK1LlDD4fVgwvp3C3i3AYnlaSaQwxJsVNpAPQKBgGFn7NQISGrrnu+SDpEvtNRM5API2JVzDoyK45lUTM3NOb3ErJYpGM6XsKLqezMlseJjwtxL6/v+cBbqxz90A8GJksluMOcM2O6Se8o8chs6942MLt4NXuEj4Dsu6Eni1XN9ICBNECElPxhCDth5Ud3qGpa7Xn4qNdGBPsZ95lpxAoGAMfIFt8HUpiA9AnvujRxcsT51GbWWjA42VflOjRNYfd5OibzDjW1Trqaa2W+NHcwc9kKc7NAPvEgFaWnxdKzvWQKF8o+AzObHFzlEampINkRTGIYWl/H1o30D1qnsXmuFGHpSZH0m6wktYZRDNx49kSEuWKln1eodRV+lFPOtI08=";
    static String signType = "rsa2";

    public static void main(String[] args) throws Exception {
        queryOrder();
    }

    public static void queryOrder() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(getSSLSocketFactory(), getX509TrustManager())
                .hostnameVerifier((s1, s2) -> true)
                .build();
        long timestamp = System.currentTimeMillis();

        HttpUrl.Builder urlBuilder = HttpUrl.get("https://openapi.doba.com/api/goods/doba/spu/detail").newBuilder();
        urlBuilder.addQueryParameter("ordBusiId", "352104134879485331");
        Request request = new Request.Builder().url(urlBuilder.build())
                .header("appKey", appKey)
                .header("signType", signType)
                .header("timestamp", String.valueOf(timestamp))
                .header("sign", RsaUtil.sign(appKey, privateKey, timestamp))
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.code() + "\t" + response.body().string());
    }

    private static SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{getX509TrustManager()}, new SecureRandom());
        return sslContext.getSocketFactory();
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

}
