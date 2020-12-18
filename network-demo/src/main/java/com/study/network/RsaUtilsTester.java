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
