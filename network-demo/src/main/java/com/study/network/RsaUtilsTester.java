package com.study.network;

/**
 * @author qianzhaoliang
 * @since 2019/09/02
 */
public class RsaUtilsTester {

    public static void main(String[] args) throws Exception {
       /* String s="/rpc";
        if("/rpc".equals(s)){
            s = "/rpc_"+ ("aa"!=null?"aa":"");
        }
        System.out.println(s);*/
        m4();
    }

    private static void m1() throws Exception {
        String appKey = "20201104773558258693570560";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHiJgna1JVAYIfeVbPm6NPrGrFxDcCi/gf6c6Rn3fUQ2pa5ZQ1InTRGfUmfmi/HRxWh6LlthlTOoagrQpy+U1uaZKEBL9ZJsHxise8P//foSGL55TWD9xCvqzFCMrvirpspAwushEZEQS2jNGt2FziDKsEMJyi0oNZNgK3TQchxLZvPT5/UZ88A6sBJips5N/GDYzGsNJzY2ABACh2F4CscjPULr3EqwifRFEIsVGlt0ACnkGko+b0f9WSJglcjavoKEAYcCKitHU4jqs3Mbke9ygEVWxaTXRLvR3RKqhOgqtpimB857gI1yF830uJ7V9n8xs7E7uNuUWHAMCIZ7mNAgMBAAECggEAJg97HoHNOaPJA2Hs2jsQ4sC7uS+dYqH6WXQK0CJABEA7yEzkgWIqMDyoU4hnSJUv8515yCF9ITAXwAxh4t6FE5uVtBMHwOSwt/dF9DWtBCZDNOGetVpfJGgkoozz0M+AkfqUzE9xDXv+jye7U1LjHMdX07vGFRTcsyanS/moc5sw09QAnlXK/q8HaPFofw5Z6DcQUrxWvefxJZuHAR6YMRziVFpoHHsUsH6ja06gGZ6qlm2LpUM7qPPre/Z3QrHMCfvAf4zYJCNvuifvUjkOAhgLeUniHRMfRqhIOMP1Q7wnZO4MoZjEVxVq9vbJ8PdxhBHaalirW3PVZzdF4IrM4QKBgQDyx26PWbvDDYv8YBZ9afNLvfCt3aOIoTvS0GhLdFyHo9WJfVs/65HwApnaPwtJM7pGporNcvq48Tx1lBl9RATTs6qQsti+6tzF8AO/x0s32mwrHx2+W4tIMB+Aw7+Sa3fHnM8YYOMfXt8qu8am9pJABn2tclb+3xetYlWTBWoNOQKBgQDSZkezv16VDOcqGADXKrx6hkfSxVL3aTWZPYWQSBTth+Io7nlLne6e2zh2dg4TQLjWmyBK1OV4OPdPM9jAvg9aFVPBjhHwOHSNPHejx7Q0kr+qxTPXi+51tizHunTvWldFgBJtFIPErMyxLnSssKcRI0IkHo9x6cTR7qIFpOOi9QKBgQCFOxacSnU05HFG7YBKEOO4VCMJdxEwgLLwzPf/OHsy4KDl08pIuMEcwoCl+WT7Jgz6ipiviIK5DYHNUJnwWWyAtR9MSymRFBhV85JLI1ZO72ne/DN5bIlx8x7GriWqd5mDDLXFvh3F8G1t6SBqLfQyeJ1tmsrNEabPuqAVj6oUWQKBgHYSY+ahXEi05v0eX0pgd0kjFidYCQlDB4splUy0xtnNycNCoNsolAKd73+7HIb9aT017NdRxjzDazYNWHRBtIfPNCOIwNRYOkAQUOueZKikOd9xr3gk1PtF8rdbEchIoHUmPDDutEuo1W4RLfTDZd4eNT3j0IgSshtFmbMlJ4IJAoGAFwDuPJH6pUmjnA8XgxSJZrjO1GJdYteTqf0LVuEoEhlKSk4rzghybUb2RTK6pfrLEG/3ACskCKesHdmDwLaaps5gY5PbgguS0sDAd1M43UoqixNCvsN7r18i2gg5umxCo+UNyxtPColVZa3Xxkw2LBkVDmZhoia2ewaih4RyFNc=";
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
        String appKey = "20200720734704051282771968";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC47F58Wt7Tm0qsxzxf/ngxeUtYYepWEyvOpsXnjAv7WhnGnqM3SfbcNbKHFeThxoj4iKYBmVfkjrz2UxfoioG5UR+mZY0zkjMR223bLP3/qgBCsScwjlV9S2XGyRg0aDS4x7eaxaDytXu3CouhMZTMUTu0VRLb5wAg6LB8qZG/X4IXi34yzGmOj4YyxrZP24Xx1ipqZR6pUDg8wBIvJc9xPaaGY+RHx3mOGh7B2/VaOzVPbRICkruDNkLvuQgzqkMbpIv/iMgP1oe7aKtMU/xr0mwkTVwotVFLD3aY0o3dfKbaTVUPh4LCJ2lxehph/RkoSuo/uhhaFRhHXFNUfOkvAgMBAAECggEAQavfmjYDMA7UJCvVKxoJwTgcI9USDWNdiVP8sFAx6R+ES98Gg5oGywlez05dLDj/Z5PPsH2ukwKF5Mx5jyGxFAjVPpiN3qSq8kqE5vNBeMv8r7KOAlZp0cc267N6nxHqtzxl3dcVY1xEBSr/j002VKD8nPwhaGrOxuEb3Am0Msuznn/pTs6zyNoYla1Cf5Bu7Zol10qf/TOYhsc1DN2F93nwT9MQRh8Kg39fd32TGKc3OY5UeY+WwSOmw87IovrQICTNvNl4N8va5DRcsafN1YGsGvL04Mwo2jWjb3wp0rg7FTj0rAp2e65OHCwLEOAm7pc5YZWTiZhcnD6Os0YMMQKBgQDgzbzmHTZFLW4HRzuxz+KZDCkunE3UKk+qdvsJJcZ8O/BGKkKnG77dk9QQ8v6I0kZUBs9Mds+n/0F5t+eTT4/Qs+ec6eYcsQiS6lD64eUT5UAOSp21NqtrYV1c8zIoPTiLnVcxYWFB8ouZl6E8kOFUbIHYwBQfVp2U5f9m/XuVSwKBgQDSldys6MZbYZ26q9u1DZzEWl4Ufm2fSAgf1ybSZAuLYdQv9xMBMLR098RcRK3Vh2GT0UF24SN+VWb7mepxPeiQP0ABChKhrUugvJkN3c+7CiyJ11ISNtyKWY3fP/PYlQCHPHoiIR/paH3aEz2E9B3+E4PRAuHzep0Kd+B81G8hLQKBgQCQgpEI2AR4CdEuKpNsJXfD7LZYeS/q0Fwv95Y+diMW360AXdBE/if+5jWvw5TuPUXqZApEXCf3FbZwWVErODz563xbOVysWv1o++mcrTQGSxuXVE33HLKrL4bF5qv6hAhib32Kh8/uhc1JqdiDR5siGzKJNEh7MMHR4twAx7f26wKBgCbG+c/NPVlubEEHjHmWfBucGF7luQHvna9fSwLK8WVFKnF6qcE6WsB/L2VeMDR1rX4utkNRydtlloUWHpmjsMN/IiYO2Md0xcxfbj+jbLEgensXb0FzYMEJJJrLh/eF2IcOl97ZAqtUVnhluppU6YDzzv4Z7cmL9ocK9AeIhr4xAoGAAs5u2GmwF7eRQ0rYY8wucXioLRR4jTfXK9lsvNUZhOEh+XwELM9F9qz7GPQdwCuZdrBKfTzb86elS9RFCp3PdubNYIlD8qSomCK6/Jm0Yfuq0utg/mv2G1TzhicwJ6wPi6wxlIFBSK5lzbQBn+y1s8bXHUbOgnm6IuP93KhzWYo=";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }

    private static void m4() throws Exception {
        String appKey = "20200615722154414034386944";
        String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCoxdgTYNJN3Vh5BBiYuNEICkvGemrAa0X77uixV9BKehS5+hOECqKycB56BOUHkWp18yFL+WUlzVPManm3wDvmUIFM8qmGLKT+aSnuZDJOZDy9ov1CuWOKkp+MfYr+LvGEZuAIs1x+pwnWeivDAQsLBvLdJUV2O3vZ/KJydYmIJTUEVdAxxBB70dA9Or+545TQsUSSxZRhgb/mepUGBL/5PbZ+MiOmQxDLae0h6syKoJmAsfPPWpcPQZUTIgio+20s+I37tiC7MMXSjENHXq5NCJ+AC2RCbwCzzj2O9V7sSbY3yuY8mJSLIvsHAAsDE/64WNtSq2g9K4N4tHjIFmDjAgMBAAECggEBAImTlTrerzBX4dnsM9yys3q5YeGuQr0N9SOUMcz2x00ezSx5JVV6kfuhF8bhnI0Zxc3WXmsfJou1H70/gm7+XhW1xGEkYnqEhA77TPoOZU+vuC/h4E927iS0tyh/4kCnpasHbVLKWvjHU2apemjgvc7EYE9TJZdmj+Q3Y3ioRW9big+SvdRKu76HNzPOpv1FAPFtwWoVU+mr/f4YJ4gNuJkg3JwuVEez26u4IfCZW+11aolEZpTOXUru021Xoaj0MT494j68wmHvTCsmHNjdOfacDm8BBSNW54EMYqkG2rYnN2ZBIp560kROCQloCc4w3dzGTHXKxRPiML7lBN+SZhECgYEA10yt3g41G2pU4z5sU0Cim7vD5Zp1uLt93Cbo6qpwnYYw34BthptZMc+Cyw2NpiOHDrypJag8TRmav+maI/JTawZyw34J10Sw1HGtfJ2qtG1o2VzDq1osBSRUO7FP2WM13QCMW3mw30TF37jOeFxIWuVnExxJcuvfBbkgYFqAeJsCgYEAyK2G3XnTOSCFQCtDC9W7yhqwR3xE2JxDmGix9c0UVI86uBjwSjCVFdvLAYxfMszktMOM+3DC26+aPNqywxrT6Uc45G+x4187TDx+RCxw92MmA+kUcDAUC9urRRXQtTcbXUoBylaBI0S+GUf38t9nfiuuT3W2PVZc0uy77pT9CVkCgYEAtxQkUUxBirOLxcVCNjUjUUyEk40aB+GfcALCUzJmGv2ON7As8qbNXRb5QJOg3SMe6MAzEauSw3k/Z2xMv76DguHz2xslYSGvQKf9/5bPHyheXV+Nn/tIrYKsAiqQHOpJVknuEKdVaTZBETJEmILYoDqswMpwBsJeXq6CwoyS7HsCgYEAry4b/xar9sCW0c9yNdCcn+7wV1b52oV+1HsAbuxZhP+LaM4MZRdH7c7yxiU9rWEDfXD/jzd+QrxmTh0z0/GFb6zG01NV3IBziTd9mhGZg7u/ocZEGzM9LKTUO/ixOqAieStzqKgfDyShNfyHTDMNayzCe4bsUVskqNQTsk/JG/ECgYAqO7yL3/oA3Kk5VaOedMxND7jJ3FqYVZs4NbC9vCxXwc04r04uxxXGSCIQ7JxK/3TWPqO38zL6N/RXcWtveyYpsL+ML1osV4hAspA557qmydaJ/VMlVdKt6Xah6prml5DyhScCW675zdUKRglY3vgVQMEAF+sJzIsSmtdvVOT2JQ==";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }


}
