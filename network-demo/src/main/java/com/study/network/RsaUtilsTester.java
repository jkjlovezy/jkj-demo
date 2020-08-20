package com.study.network;

/**
 * @author qianzhaoliang
 * @since 2019/09/02
 */
public class RsaUtilsTester {

    public static void main(String[] args) throws Exception {
        String appKey = "20200623725013202391269376";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCpM0oBs4Ot0tJWpdBzAEiSY76gdR/3pSSFuQGQlXZRTBUbDYK738G7tdh6Y36HEnpaTCsjyDwQez4i30h+SDSNnBpjDZL8v/7+VqJpA99LFJmXFIjg0VY8R6LMhXR2xaIvGYv78OJ7106xfI53qe2Lvi7g1M7j9w9dsobhlYQ6pY7n8/4h3bPmwPl6BDWpGQMIl9mCmy1EhX/oEHj/IDC4DRII++q6yr66Tc4anmKiNUn2xcHiAr6nYkqnGz8geUIa9fbIndZTZZmLH1AtNPfWnpWW/9iyG7bvMvC67gThUejPyJhUG3vdnDmVvLRlKAFBeMg8iCrPurQAlFdDeCHbAgMBAAECggEAEv3KxL4dfZk4OrmJ2B6kBqpjbyc2W1mR6+CEKHJeQWnExLCTh/rph+Q1VCduwEJ2sUPzY6TJ+R+cLdXaETKRk4N+Arg3U19Jg8q9mAPzQD4jry2C35kfkMyJnWMtW1d7iMXZTIIRKc1U698LLqtIGnNSV7ILNtM4SlALi654lQxpbAIz6/h+VAcg81hy/oqEup3sy/4VTkWnNS5UVKJUh38k2pNtHGwTCpGxgnyoWhWWJ1oOeD1WgIpUI3FoXP89PCDi/zGMz83zOyQRqXOZljC4v10kDvh1VJnZQW6Hbts0hyqHFHQ0RNCtptR1KwvEbG63kujzoFQTE4dv0Nf7IQKBgQDWa3ACObtiJHF0T7qwhmwGdwlfqdgvqKzH9esKGwwSeErHTDTZS9+Xk1vVDO0tVEtM5rKEXtpapD6UuQvZPHaqLaCIg06eT5EZ988yI5ORziWsxaSfY9a46qaokk9h8cnXxIkTcjfQiJuHXc+kjlOy+z/K7p9qC7NliYHEfc9L/wKBgQDKAwBvyjC3gCMUUngSmp5lNkjBDbLv0KRTVygGhb5To/+rbQC110gpSZT6/wAKDhcVQIL1miIrkYS2tBi7R45q/EtMlH+pj1uP0xf9RXH2d3p6SQIDSjbsBff2eEDIDjRJM19RsKKihs43u/WNsuGwIRWhgsoKFTIz4/vELjXaJQKBgQCCyMlrMhePhzcEgNUYcwVU9CpthUVt3G53ERKp+VFluqWx5lOd7t+Urrcmvlm0emPrphNhFhINk3zwbeZCPNUMfAQdACpl+ZZBxptEs9qA5sKoHW2KIvWHmOjKjWOKFFbPGvuZNuPAeHKVIK1Ua9O1qfaBKwdlQXnNBxB1718PtQKBgQC6S2ZdsaKXt02iciNVVM36HMOfdZis3EaOrPO2gCRzUex4FL/w8iYUHU2M4xkQLMpQyPt8r7YPY9V2AERGgcjvFNgEOXY50oDn9A5NfXuJhcmneCipDAn2Q9LWszNayu6hCwU+epyhMZx/fZEIKg1Dtl8SYWEdR0rS287UrqDvGQKBgAf41uSng7o8DFgsVzdh8728FQzQH7sQ2FqVfXhR7E2USwxpqdjjGVjNqIGNHcH3D4w2x3yGhmsMRZKX0b4EH01P9eil5nygRv5oF5dMN97dGDbfKMGrHotTRVuRWPJSkQH3CaZzsn0MAVJ5XSKTvrBtc4m8tZQZIlxX7Z3ixf9+";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }


}
