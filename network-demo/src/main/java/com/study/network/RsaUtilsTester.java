package com.study.network;

/**
 * @author qianzhaoliang
 * @since 2019/09/02
 */
public class RsaUtilsTester {

    public static void main(String[] args) throws Exception {
        String appKey = "20200818745329297027235840";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCreymf3Ah22Rq0XD7ZtTsgcwMsaOC9YeENE5onGvz3oz0cigHMYHSJwBAiRbIe+xgGFBc4mssSrhcAYbmuIzfZeK0jBd33SgIMignv0K/ad4yGe5cVHqYNcmsbdUFZCIqta5BWGVgpPsJvcmoi83FecWN4L8lY8jCACuG1VPV1BCprL3qB+WFe7HXd7kBAC8wJIaDJZHaqLaIf5VG2EBoMrJZ9Gg1+NRX8GfuGkRp5iMJCiIWqMAm/GyjNEo6/3WTtFwtNjt4HLO/+UCg3WiKALE6g2I31/6lLF96tE+vyTT5eHap+omAU/vfeElAzvxreCpsEoaXEFQlAWAOxPHJdAgMBAAECggEAYfK1seQCya/0uvS9yajlHwHS3DkDtekEnW2G7bNSrziEnZqOsGif6FbWYF0jAuM1s7MiGGkCeacK6GLppnfjXMq7Snf9c1TImtT2HA89gzIqCF7ry1p4StICL+rn6q0gWTJJfYR4gQaiFPpreY9IQEPQJ0RUZAPihCCzD9p5Yd6Rf6DDWJk1WePEwUK6Seeaw7MKEOMmCOHAXWLip6WBJAC8WWy5nb593wbiiktE5xQjipNgk6jFYJSf3WaCDf9BUDGfN82vucPlz5d4YFXO8aSdxHgPh7tIYbO/1g4rRXO2gLdiZA4nEBO4TcW8akN6R+5drvJK5bIJUlYRap582QKBgQDeLPhcM66iDQcj2h4U73ZQB9cQg5WXoMmErYLQvviNBKcgmQ7SVsaQZXPqw6ZH1ncq5kF7jQTWmmtgLORQ2+yuONzZaeev5+LAcWSZdhka9Zc1bYJl55r4l1YZFYv4ZF/41dwSKJ0UWHR9qcPs1fU3F2LW9A5xZBlVer8LPd1CpwKBgQDFlm7K3UWT33oER3cT4Y0teWFWinXaNVaJ3B3CxvlKhX+qbLN/QCjkjdJUGdMnF7PXkiyC2dpfdmi9ffwMpfWBaCyvhSnQ+BtJ8AuToBlGMAb+haz7C5j6aqn578qUITZLq6P0lIzRTvdDzJAUVpvVjjfKpfW12GgItLzLF3lXWwKBgQCuTC1TeCAqdXoCgF1VIz94LY5lIDW9TKCLe+vCg+9OAjZy9mCQVw9TvKOhq3fJp9C5UQZSPSFskpxmSRGc9cvKKkXoMpNWht53Bv5a/jFX2w+TFKRV+cqz91XOO/8hEO3Rs0UA4efJTFOnOgXAyWGkpK4f4DtsbZEKZE94LEJmxQKBgD6Z9uhXSuAbAfGxIs0tvSkXN/vPSp+kHpL3Joa7u+gce+JnJke+8DXZqTX0KK5OGDDIo0mh9EoinfTLobvwKOSjOOUzb5hBw4Odhk1zgA540P57I982QXW1rbz+eFSOYUGAVCX9mtAGENluSofnGOCEerC9/CdtNSjs+pPuEAfZAoGAEVzngcqNY8Xssza5AAH8Hfb09VPNj7C2fWrXOQcXXB3KUFlOA1HrxrYP5ApMvD3v+k9SXDw77b+ndheiMvHPSBXYm2OMq89ftiuPIlBnVfQG2ZVIzMpC+jED2+o5b8gyEXpsSm7xh5fvbYoAD39+QEedmFR1VjI/YtsNJGls/Ws=";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }


}
