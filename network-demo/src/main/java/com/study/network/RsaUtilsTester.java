package com.study.network;

/**
 * @author qianzhaoliang
 * @since 2019/09/02
 */
public class RsaUtilsTester {

    public static void main(String[] args) throws Exception {
        m3();
    }

    private static void m1() throws Exception {
        String appKey = "20200818745329297027235840";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCreymf3Ah22Rq0XD7ZtTsgcwMsaOC9YeENE5onGvz3oz0cigHMYHSJwBAiRbIe+xgGFBc4mssSrhcAYbmuIzfZeK0jBd33SgIMignv0K/ad4yGe5cVHqYNcmsbdUFZCIqta5BWGVgpPsJvcmoi83FecWN4L8lY8jCACuG1VPV1BCprL3qB+WFe7HXd7kBAC8wJIaDJZHaqLaIf5VG2EBoMrJZ9Gg1+NRX8GfuGkRp5iMJCiIWqMAm/GyjNEo6/3WTtFwtNjt4HLO/+UCg3WiKALE6g2I31/6lLF96tE+vyTT5eHap+omAU/vfeElAzvxreCpsEoaXEFQlAWAOxPHJdAgMBAAECggEAYfK1seQCya/0uvS9yajlHwHS3DkDtekEnW2G7bNSrziEnZqOsGif6FbWYF0jAuM1s7MiGGkCeacK6GLppnfjXMq7Snf9c1TImtT2HA89gzIqCF7ry1p4StICL+rn6q0gWTJJfYR4gQaiFPpreY9IQEPQJ0RUZAPihCCzD9p5Yd6Rf6DDWJk1WePEwUK6Seeaw7MKEOMmCOHAXWLip6WBJAC8WWy5nb593wbiiktE5xQjipNgk6jFYJSf3WaCDf9BUDGfN82vucPlz5d4YFXO8aSdxHgPh7tIYbO/1g4rRXO2gLdiZA4nEBO4TcW8akN6R+5drvJK5bIJUlYRap582QKBgQDeLPhcM66iDQcj2h4U73ZQB9cQg5WXoMmErYLQvviNBKcgmQ7SVsaQZXPqw6ZH1ncq5kF7jQTWmmtgLORQ2+yuONzZaeev5+LAcWSZdhka9Zc1bYJl55r4l1YZFYv4ZF/41dwSKJ0UWHR9qcPs1fU3F2LW9A5xZBlVer8LPd1CpwKBgQDFlm7K3UWT33oER3cT4Y0teWFWinXaNVaJ3B3CxvlKhX+qbLN/QCjkjdJUGdMnF7PXkiyC2dpfdmi9ffwMpfWBaCyvhSnQ+BtJ8AuToBlGMAb+haz7C5j6aqn578qUITZLq6P0lIzRTvdDzJAUVpvVjjfKpfW12GgItLzLF3lXWwKBgQCuTC1TeCAqdXoCgF1VIz94LY5lIDW9TKCLe+vCg+9OAjZy9mCQVw9TvKOhq3fJp9C5UQZSPSFskpxmSRGc9cvKKkXoMpNWht53Bv5a/jFX2w+TFKRV+cqz91XOO/8hEO3Rs0UA4efJTFOnOgXAyWGkpK4f4DtsbZEKZE94LEJmxQKBgD6Z9uhXSuAbAfGxIs0tvSkXN/vPSp+kHpL3Joa7u+gce+JnJke+8DXZqTX0KK5OGDDIo0mh9EoinfTLobvwKOSjOOUzb5hBw4Odhk1zgA540P57I982QXW1rbz+eFSOYUGAVCX9mtAGENluSofnGOCEerC9/CdtNSjs+pPuEAfZAoGAEVzngcqNY8Xssza5AAH8Hfb09VPNj7C2fWrXOQcXXB3KUFlOA1HrxrYP5ApMvD3v+k9SXDw77b+ndheiMvHPSBXYm2OMq89ftiuPIlBnVfQG2ZVIzMpC+jED2+o5b8gyEXpsSm7xh5fvbYoAD39+QEedmFR1VjI/YtsNJGls/Ws=";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }

    private static void m2() throws Exception {
        String appKey = "20201028771070396366585856";
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDEvH6fqBUO5qdhyj5VwE3zUv0fx+aLpJIa2SSRY+PmsLPJ/6AFim3pbQj1TpMU8+tbHx84heXxOqkwOkZQaXTkGXeUFOKbAht49a01HF71CN3z+mJPAPA7JbqoemYuVvKzBuO6xfUvQBO/5Vrpi16Nc/3ULiW0mzwFQGX2QQDA+i+krfx2X3jcvqvNPVN9WLbOJFDRktF6QnMGnqNreSVaLxLZfwjqIzj5TCJ5RJPdDc+PdPmKi59Ume5CjnzAU3AGeDbV6rSHltdqhEa/7DlA/HEyubS/HuYm7+yZUcAGbHUs7Ak3GpLhu+tpAG1l35jlsrnd72rZzWKMgZS3bKeTAgMBAAECggEAD+j+hILfURkuKCZm7CBlLWxktBFCf8CLYEh3QJrHb3ySzZ8yncAYK2x58PytwGAJhJD7wWJyuhN4Y0ITNaWRonC8zujxen+tIRcdLtJgi4hwCq8RDDqTMvVWJxHe+ZhmgDvqZsxji7Ku5jHyLDjtKJtcx7ADtJtpOzN+C3AuU2zD6M8x0ZnbmHEb3B0MBOnfqUY1BP+4VR1r9kTUnZYTaRNVGDeCtTlcYb/FdrtWMNCJdoLmBjSmmidcnh7CXrwoXPRxDsMvlaKNHvCijI2opnTqSRk5KMYDQ1Ywi7GFCYSR9LwGz68CSpFZ2X40edm7DGT25NW/YMXM+TaVMKLFIQKBgQDieO1DDlXE+5fxfNduclDm5E4/vknbYJh9I2gL7e2IJt+HiUbzQUX9NT2L44dTbJ/7xyb5N5xdRqW9qF4M2buFFbvTj384o2gpChUvPe7I9QT6Ya6a1y3q5f/eK107GSkb7s8K9x7Y9NcMSTGq5/aylnH60Hsa24yJ3Yo7f4ULHwKBgQDeYw2v5pq+ZRP42rDaUm0GcGlfjlKOsaIuIDqCgdvwtQOCQR6iFgXsNRN02Iznv+YV58eyNvvHCf6usfvcaUXZHI4dLd7ooKZWM7fb8UR7HFyrRZI8x7c17G+UOzwp+PiaSmH9fbjH9A9baZw8yh7C2ZbCDpUlwJArnfxBfdkJDQKBgFtianLtfOSQlT5HnvKdRFH2/DAyi8DvGHkeaWSu7HNNJFOfrDaKN0C2VBB3jmq2YVQKh4p2yyzETiranqDW1xkbrP/wXmivX194BxZaClmirRCPjBJFE+0+Q+IVY3huba0szvTgxNzM5124x0bsdRqZJIMNzy8GOo6DC714dmoHAoGAdWUMwKKXZZKuLFwlp9qDOzb0KUFUS4dx+a+Bs4shs7uakpQVu7KshbivAKugFmay6zVjsaxc1QFttIK4Ve4stSPh0X15govrwu2iTTTb1bFvKeqb/AHhsVGSxUlPxUhs0+YYPFy1wrgPs03Y8C4yduGuN9rC2R8B/ER1+YyZmbECgYAXePilWrXQZNvkak4JPyiFECz9hyOaoUS0AV9CxKJuuTARPSXdqRQsjiHGWb0Ntxoy38VtN6GcHI+9jVJ/NWrANsfzeVjULJwY4PXztJamdpwUDLDLeINCOGtZXghFJllBGZ7tBx6t6OOs2BOl5Xswdaoq78YA4GH9OmxbS7ZxQQ==";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }

    private static void m3() throws Exception {
        String appKey = "20201103773281123722592256";
        String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCAzl53ih6ft7kmRKe3bZToklKRTfQ4Kei6G1rfqSrGlKPjSjuj95AHvAGRDjMoEPwtJaktA9bDh4Fpy/BNWkAf7p3hEvevBsLvEoEItbN3S8sHf1mejYdZZIkACDOr058q5AYIR8cieqY0LGcWOgHcUjwJ1ZdmETLiTrB48lHHhTIvj+fwMz9Bi4P2Na5nuu79owpKsDdXe7jEtBZ+7mCuf4TkriDNXWAP2q22fRF0QwgA4igpxkN4yqTd5U85dN97YJ0kBedI1tqKSEJGW/oiJ99cGCrUSf4+90XIy+dzbzcVzE4FACk3cN0kRcvH/EgJdfKNE50+gnW/A5QO79/BAgMBAAECggEAZLh6+EDiB4TT3A/Nkkq3KVHaDNOHSC/FU1o2qjSPRW9P5FjU4DeiwdmK5BHVgNwfRXJwosmgs48PbFpT0zjicdXWUPzS/2NrJSU0D0p+RqfW4Er+GlSTZRyPYJ4JQbCegxyBdxIhrl13/85E4gWEFPOdDRefZunF/18G8dyShFAM26K23LRMk6y25LJTpzTsM/d7VA6Hwr+Wgyu7l6g/kixc8Zhr61nc7Chr6fkt8O6U81lEd5X7fJlHZHdVUb9RNIOJt05I0SYXyqc9DkOebM/4bmgVNjQmeE+lE9WMnXbsqSUU5CEBlyS7x/Z5rK4SF71XHv65SFlKGBFQUw5cbQKBgQDUapCsPwDTac6MiuUdYNbCBUH+r5nQoweb9AUhPwk+CNrt4lANOzj371s7bEaXKG+SXiVnDph4L6woStWUTM+/NdOSS1CLzs2ixWbUY+xhdJ4S6iqn6SgMAEQeHN+hdJJcmAfP34nMxOEoMpWHUP01OA3oZv44rulMG8WoGhWIOwKBgQCbPBMoSvrgN03Q0AVrMvAgrVRdkWCLRmIDS3gwgNTMmAu1qpOFEqPtpjafeLCOW3L1bHnd3EoT5/MPwClSn+6opv9uZBNTUSizAdgvJkuWBKa9ptd1Y7SCI/lJ5Iw+jB2HStSh/MUs2G+r7cu76hZF+htcWLzjPojrm5oTPRF0MwKBgQCLQooywuNxt055CZ6IEjL55KSNquZ2yEt2zRaH42HVz8xoZRUCd68zrTLs1GG7PAFZvmtbE1CWivqdN+KqZWlV/J4GrWXTIvPiIPT3jcMtaV0xHWB10QA2Tf5al6dtnJVQK0QD3pPjMbhDuFYb7tbyixtjIBLPaqz8/sApI2C2fQKBgQCRV9kUA8gLAJziIrLAIOxFnCP+i2waWubP8OxydV1Ixh9Ik5IVqVNE4jgIbebZEvR6p3se5++P3b9tAt1t2AKLc/h6skaJ3tY9bD+uPavNpUM9FKZs6dKLewUgU1WgBm5rSvv1QwaWK3u7PSVhJxZ9pGPTvd304osuFf1Xf/kEkwKBgQCVTNkL0AtDquOIlNNETzVIl4OPTlE3RyeeXPxtbuVh71ca7NJc+TPiguy9QlPpW/u8p5wfsmEh26o1fCzDCcq8heRvXoqkaAEglFAhIBeyOOwIe01UztukYiiVM7S7SMl3NU5RveGwMeiP/R5NSinGZc6VDwAmfv9n9+eCejM/lA==";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }

}
