package com.study.network;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author qianzhaoliang
 * @since 2019/09/02
 */
public class RsaUtilsTester {

    public static void main(String[] args) throws Exception {
        m6_prd();

//        1614311048092
//        sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
//        1614311115981
//        sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]

//        1614311426193	    sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
//        1614311490156	sun.util.calendar.ZoneInfo[id="Pacific/Kiritimati",offset=50400000,dstSavings=0,useDaylight=false,transitions=5,lastRule=null]
        /*System.out.println(new Date().getTime() +"\t"+TimeZone.getDefault());
        System.out.println(1614311490156L -1614311426193L );
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1614311426193L)));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1614311426193L)));*/

    }

    private static void m1() throws Exception {
        String appKey = "20210204806817386266099712";
//        String privateKey = "/JxASGfsv55X7rQ4k5PtuazpfsYUpQdll/SCu+igUabTP6f/+zDIGWd35MaocH8pF+xSt8K8sJeHOhEUjvQR5W8sbMJbWHWeYzgYaLZQCzLjDFGTfhohQr1K896NKYxtMzcVWLJaKqe3JjmcW0aCjp8xJYcRrXi3wEdsrLdgg8JHHLGHq2RRPhVE08loLKHYD9K1lqKtuqSuTgylSPTFUmO3g7WwCFS6uYtdrfe1IB9qrl63mPy0oh63HftaBnTbg7PUugbZFi1axD2jOfTHuHCiHLKpHCY17WmwyivkSUFPvWdmmBT6NZOTF4F7YtAgMBAAECggEAXwhtoKICNwjDA2krwqxFcyF7q+FY1/e8mGpF4JRcTcvZ5o8G6/7jUi790w83GqZ4vDrPrMVDA+sE5ox6DTZWu/Kyc/1C3VLVcgm9ViFaNBfP5WFO/mBe0e3ZcRf1IZjyxrNBSyiMBtHQTOlXbmNOpEgAbcVvi5FkMM+AzjPeBIaoGxLG5asa6uGtHoZdnDyN4XQ6gjTx+x+7QcZyWRNd6mnNS6WUpZsl12H+u15azH5vi3qeTmOeKfGNP03QbV5bF+oCwDP0Q4SoiNWJhxy5zzPyMHwKxXSs6XWgDRVELXpkMLzLxIHvlIevbKREzKMWMYQnooobFWy/rHxLSkkAAQKBgQDAZuDMzv6qe9M5wQkY6UUt5IKzhtWiyCdPD1SCVg1phShxX/NvnZxf4mVwRjqZXgu5hk7NGVrM7nlDMfp37ylGRgruncax6S93AStE963Yj6979BvKd20YIj7IM5BN+CroQ4P3XTT/2DHKeL/Vef6HhjjgL6DeYk7djcqJXLzUAQKBgQCxfrZ+baAOVF53QIOmHQC4fStT/R0vDAX1akqa043itnB06fexPR3y/mwW69EOpzNLYkgH5zXTAqUvz1W1FOk/jISXusWRIPHpKYjN0vDKO7tayLhAwdU1iLDOpHANpK65zfVtn+QWytVwouFvvaxsDYo0Wu/gORqgG3cfvH5yLQKBgQC/EOtJOH5aWyFGB1a7cFwM2RKaqdnaD55JutWXoVEsatngzQJ44zH5XmCSAIwM5gIKuT/kGbu8K04s1qL/G3gHm2Mb138MCp/iNDz9/mCb4QTJuX8nrzWdc9SZB+vUIhCqGvIgYmVRdSbtBMCshLupZjdxGptMfKAJENgDVR8IAQKBgEL8HCk4fAgMZR5CNazSEzyM2HY49vOTaQhGVeN6ZXii+2vUBItaElxrEiXQVzRde2k+rQp2goSg4fBaIfFV8/TstfmBHiB4O3OQHjX3HrJjuoA3cfnWbP1oGbnSqwsrFFnA1ZfKmMzVPZnljoiaH2Ej9v1tOEv5oQe9dcZ/X4T9AoGAeZWd3xnLkKmZSbtUUzjQRmq1z/iXzovif4NxBKSzt4X+lQT/qYkoEN95dRD/r/XwdKQqmT1L1xHOJwSgL7TAaf8ad4YStreTl2Ygog1429O/tpHRLmZS6HH4Clo0+ndVHJCT5gbESbe6XVvDf+HLIfzbbfSyd++TMV9MYNVLzL4=";
//        String privateKey="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCC0iYr+4ffAw/Gb1V/STE27uKLGlPY8QNPys37ygufYwUPKEgnzMSMH8+Hx0n2Y0i8aFKqCly1E5GE79FwdLApn3RhfopmDzb2pSHZXiINNN0iRpOeE869edzYhgsBK99tFCIv+kMfU1y7TkOAhjoTmqf4CLBGkgu9gtt0q5tIdv8O0+h6fxlnMcCOG9zNK1WfNHQmrcUfTaYp2muM2CmLFkDYQmA7jvRmXX8d9sHV9XmJoRjfjmG1gQE0Jkw3I6ajsvV7ir7kVrDVKvf364r1mLWpOpsiMAGNJWDt4UEBwRnMTORgG6leNTrs1fmcOrsANMINdRp4oKgXDVVgOGrfAgMBAAECggEAUwwdd2ZiRsymww4CdJ9+QqU745p/CAVYWNsiEGmfHzu5BnpH9Bwl2d6H3GZDKcq1bgW8FH4nhDw78OxdRMqO2p2DQDEYotmdxs3lwxvi+gdJKm0rYPqqD9bAwCO38LJtT82sNlDlM4m0IKP6bijHzZIsd2TsoqAsG85qipI2LbWPzzvGZlHhsdsOgFaCl0u/Zv4QBka+B3yS4ghgy7UyxipDFq4dkTML0Z0tr3oX0QJT0lFOSFkv28yK+VQmwzro8v0rSI61PoDk5sRehTrLLnQauCxaS4LBHrJSUnV41+IRchNig4nV+l5nHwPlSmuElO+bLFS9uQsxDHPXQKUAwQKBgQDgm0WhD4zFBOV1MRk09XrAKnZ7RFa3UHL/2cMs7XyxkLdqceAlqgtsmNzfQ15KxcSPDFXRCbr9ud5FTbojWD9Pd4CvLdjXQfYd/yEgEcx4N7LvP+X3nX+jeeLzobJWVR1l6l4GvHyWr4f+ztU0xHxpFeoWhazASt30Em85d86piQKBgQCVGxlht1f7Nm7ZT3E/nrI9q0zVC6X2HdiLAEAu6zoaTgYTQxsYe80kScrDXc8V8iAZpN1nhtI7g1lxp9yRFgPLe2mj0oTmsQiPo3Ns3yXW2cOORHdNpPM8tzXRnY4fx+rZySSEvllVwGVOcfbMe6+O7Zay8HZaiXaJovjog00fJwKBgH5P1ACXthq2fjRBwGNACiA3wRnhfMLqw0GPPWvuwsk5EW0TTXLhBju0W8JTKJv0TG4GCdzdFAPMm2tuItftsO0Hz560sdWcisSjzgUy/UI+UKqrzLBMKpPM4A0TSi+y/i1qeCZhqc80N87ckppyRWTzpgm0c0pQ0DGKjHJNJjPBAoGABZzeiLohGrjC1XVTGwT7Sqz/GGn21lvrQdhBkkKSjljvi5wUEgjfAQWyF0aZvAbARJbbKsF9enYIUOnzuJZukCNWJ6+OBy0U2GtbtfZ0czEBVoKnRwn1igyPfxOCPRoGcipLMKAFtt+mMJzDoJDrW+L/sD6zBdd02duDqSUAKzMCgYAaCas6RHEWAgOTAXyMmv+CpkjcB7fl7uAC/6MfMYdDiYF/5TJDW28brMtpONUWkr0EYkp0QTI+uL+BQiSGbbJPL9MAM9/atRt1RcUl+bccXmwyf4L+Tfp6WOCJx7hThS4bSU/dLHFMKbEJmYIIxe0mRIY74bbzbRurnpUztwc1KA==";
       String privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWqFva5Z+Qid1UHg2/w21ySHaMaqltlbswdxGUdn0xG5lSOi8SadP24Z0WqrMLMa9PCeNJb3HsLpDRQjCdEnIPCc2IFImxuY97iHf1WkVkiiO5auYt8Ui2xdOOv4MQSFLSHCllsa7tGPHDxOLYTRKYBJeCMNy6LlC0hSe/aEYLDiX2QwWDAB9BuxtSVG94VFRPWRru2tQSu34tlbvk64bb+cva5NTtAnDZJN/AGFr8YK8DMUhppr4ba1rn3xLS8es1t2q2k1qJRvC7In/NA4BI8+wlKiU6AyV0lxhiwlqff39FPviUW/DxvY2MUIEH6AW3JW/rFrcvSDIZzdUKy0jlAgMBAAECggEAVBV41q3rpX7ccVMot0s6LVt2Fp59GzVDOSRrQmHzM1JE+xiQJwW7kIGQ7BKvROMhBcrt+JFjkr7WgoQfn7qov+3nsThNNUzsYLTkxqHwMtHKaHTaLPAKdj/o+DW4z4CeALhI/oHxsFCItouPU8uIQiHl8XqV5q9syaO7cF+hIA+THPHc6/o9x8QLM20actN/XsAx5etMIh3G8FMKsKwp6MlVtYrXEY8jQR2zmZUqGXjWCWOAp3c0/x4fUBy3bHP/O9W2SOPzfwhoKM5SsQdLoQ9qUiG4dVRhggcQiIN+2Rx9DdQOPSUQcHTjipoWsKjw5ihd5wy1wKnHZeYravcSQQKBgQDhh0DevTgF91ujajw5j80lCtULlNPRRZDBfbGpZFCFodWluEVXfXwUuTcmNF2OuP0LxgZoGb8mfebL9yhrWqMidyms7ne4JzwMF5cvSTt07Vq2f09BSlWHd0fYzmCRh1MCwnB9pvf70NGW56uF/QP5D2PfDtJK7f2EEbkMISbmVQKBgQCrA2vELDeGBNb5tJ9ODFIsYBZzvlsRWW0biTGl+pkRqv9PY0hFoV6rkyjMOyGxAw4ytytLvS4TRStf+5i8qyUivOGdn9WdQLw83ayI86NzB9BdkOLNUoSsrWmojXW3SO7YeYg+03imOA7TPTW1pJNz6rhVduzo2r1XyTSvCWLIUQKBgFGJYsykwHJ3wavNJsTw1oxD5E5xmjsY2YL6/JZvbCVEI0fs3TUKayfa5rNrTz/gZawyBfLxDAjQj/bB/t0BQeWeC3U4KhRsKut8Q+6WnWZiwd8lG/RQ+acmWtVpl8RFlp9yyNTE3vctwfi6/WpN1XfgNo1YgHMSpAtxlONrwPKZAoGBAJUAwA8HL8GXye98Dymj1p1Pg4CJpTNypXxOh3HE7UXVpep36OqydZgs+mkoRGzE6sQJkLHHPbQQmoBg6W3J+OtRg4shTrBbTSgDRWd2UT3S2xwLN3IKqgsCdYMk7iIqa+E10x5ah07cnR40wO1pXgirxLzCiB1DKaKpbzvrg6RhAoGAJeprGMxJjyhnrNT/PGDjXrXYmCIsUBxyGQe2r4dWxGlzmDaR+FXccLyBLg1dERDVpAhquXtPmK+4gfokhjNZPwhjogtV3yZKji7aWqZIhOai1/Z3EVEY74pzZJyTqDQkbqWOQ44YGf928TY5Oior2HOJzlo2Vy+uzTHq/MlucYw=";
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
        String appKey = "20210319822425910526345216";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIp5FrJio4LEX9pskcubTyeDpl5O4Z5cykVS+8cUBPiITkA/U5LYTQ+kAEm7sf8mJgE2uEBUQ57VxVerzs/B3l03DqkHg1brot3BD5pf5vGCk8tJozOE7jQVheXu8GutuBofVNzsqDoJPgrGpSM5kurNDfRyXaYh6LcHC8ypLTTxkGPvvhxp5iEW0HwdCtCRfgfduiuYglq9SrFiW0omiK5D3mLLKrQQ8qS0jQxiaq1lICQ9RqAz1K9p+89ZzYmbVyZUP6uUGyT2mIMJu2El8W7onmd+hbnkzWGn3owbf1umhk7sIqIgoEm43FVrqUXnv+Aph1sZjKr75jqHSiK8jvAgMBAAECggEACCYV4dHQyrC5K7r6WyAnzh2lPdY87IZrgZEi25XVQ+jcI8yontQ8C0og7yVqLymA/EGsM58sxleFHgPHqEoQblgBb7tVr7n+mCV7Tae8WFuUee47E7rT2XFYF6iJkFksJbrGqfEe2mKE7uzZGjXBeKsNeYMAmtknASGfV2KtBrSln6TB1zGAxXmMkY7oXbODSQ5ypKVvJm1/EX6GRB6LOwl7x0KPzlkWjByKDbjVZgwN+u/yIJqtzxriAM/FtHa1DH9/QvzHcfqSw1uOwKnv6JacMC6r/PQL9PA8iidETjtHAKP9csrrnbQeeNciFk76zL1FOyWl7cEoDuzSun8ewQKBgQD16oZnzs5lG3axUfxJB6zdT9zY42vAFhTitVcFjrfncylBx2HBCPuV56LwwajcDON+kOiSdnk6laJGb/CwgmZtdnExy0d64Hv9h4MrO2Um1XBn1K4WlfEW1ojdFy0LtY0ge12ED83q43nZ3b8wtx+ePQhqNSzzuKtHyk495zKntwKBgQCOQhU9FaIE7/vPrrsvTZbbrI1g38pB6Y2tHPI8iSvKnl2E2Xbk/zt1QFvz0RZGPGEjKjiZsbe1CBWm4XjWDIs5GcnmhrJWfdhaDu/bHAozos022UPppCKKC1jvAhF/m6bHyWdxijCXGMOfqm9BtmVPwPkA5OHbFkUQqlOOB6A4iQKBgQCsq7UeNL8FjWglD90mZkZBy27Vt7IT2S1nFk95LoIA+QKyFk6UXTtSQahOhpyLjl06pIM5PAjZUvHzpWwKdDV5jN3kScjyBafqF/nJJFZdEydvMI3ge/4hvBezri9J9nuWoCjErtg2ou0PRj2V9i80S8SZ1qaupy9VJD8WBj2yNwKBgHbojdAtUOxHnHgQWa5EcKDWLqaW6P0HN8FHvMMU9WG71ffBvjvTi+OKFFJMpw22UouOMxllD2VmiJKhTNu+SHFGORlT5aWeM0WzzpGbcnuOzXHXUYjuBWDV81R0qiO7+0Br/OdO1ya1MG85ix2mVDDB4GD68D6s8rXnaUgC383hAoGAULjOd6VjjKoYWCba0bUq4HHuGlLH/Bg7RjN37DHV8Kd0nCuHnBnesZ+E7lw6z/gDLnp/FVx9PQdHx3BNs96Q//mlUxIVqDGZC8/1yKoXXpAd6juncMW8Bo+9+WEuncfq0sR11c5Z7L7GufDwqeGmTZ0qvhqR8itLKWl9dTWmkI4=";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }


    private static void m5() throws Exception {
        String appKey = "20210325824570945661304832";
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCC0iYr+4ffAw/Gb1V/STE27uKLGlPY8QNPys37ygufYwUPKEgnzMSMH8+Hx0n2Y0i8aFKqCly1E5GE79FwdLApn3RhfopmDzb2pSHZXiINNN0iRpOeE869edzYhgsBK99tFCIv+kMfU1y7TkOAhjoTmqf4CLBGkgu9gtt0q5tIdv8O0+h6fxlnMcCOG9zNK1WfNHQmrcUfTaYp2muM2CmLFkDYQmA7jvRmXX8d9sHV9XmJoRjfjmG1gQE0Jkw3I6ajsvV7ir7kVrDVKvf364r1mLWpOpsiMAGNJWDt4UEBwRnMTORgG6leNTrs1fmcOrsANMINdRp4oKgXDVVgOGrfAgMBAAECggEAUwwdd2ZiRsymww4CdJ9+QqU745p/CAVYWNsiEGmfHzu5BnpH9Bwl2d6H3GZDKcq1bgW8FH4nhDw78OxdRMqO2p2DQDEYotmdxs3lwxvi+gdJKm0rYPqqD9bAwCO38LJtT82sNlDlM4m0IKP6bijHzZIsd2TsoqAsG85qipI2LbWPzzvGZlHhsdsOgFaCl0u/Zv4QBka+B3yS4ghgy7UyxipDFq4dkTML0Z0tr3oX0QJT0lFOSFkv28yK+VQmwzro8v0rSI61PoDk5sRehTrLLnQauCxaS4LBHrJSUnV41+IRchNig4nV+l5nHwPlSmuElO+bLFS9uQsxDHPXQKUAwQKBgQDgm0WhD4zFBOV1MRk09XrAKnZ7RFa3UHL/2cMs7XyxkLdqceAlqgtsmNzfQ15KxcSPDFXRCbr9ud5FTbojWD9Pd4CvLdjXQfYd/yEgEcx4N7LvP+X3nX+jeeLzobJWVR1l6l4GvHyWr4f+ztU0xHxpFeoWhazASt30Em85d86piQKBgQCVGxlht1f7Nm7ZT3E/nrI9q0zVC6X2HdiLAEAu6zoaTgYTQxsYe80kScrDXc8V8iAZpN1nhtI7g1lxp9yRFgPLe2mj0oTmsQiPo3Ns3yXW2cOORHdNpPM8tzXRnY4fx+rZySSEvllVwGVOcfbMe6+O7Zay8HZaiXaJovjog00fJwKBgH5P1ACXthq2fjRBwGNACiA3wRnhfMLqw0GPPWvuwsk5EW0TTXLhBju0W8JTKJv0TG4GCdzdFAPMm2tuItftsO0Hz560sdWcisSjzgUy/UI+UKqrzLBMKpPM4A0TSi+y/i1qeCZhqc80N87ckppyRWTzpgm0c0pQ0DGKjHJNJjPBAoGABZzeiLohGrjC1XVTGwT7Sqz/GGn21lvrQdhBkkKSjljvi5wUEgjfAQWyF0aZvAbARJbbKsF9enYIUOnzuJZukCNWJ6+OBy0U2GtbtfZ0czEBVoKnRwn1igyPfxOCPRoGcipLMKAFtt+mMJzDoJDrW+L/sD6zBdd02duDqSUAKzMCgYAaCas6RHEWAgOTAXyMmv+CpkjcB7fl7uAC/6MfMYdDiYF/5TJDW28brMtpONUWkr0EYkp0QTI+uL+BQiSGbbJPL9MAM9/atRt1RcUl+bccXmwyf4L+Tfp6WOCJx7hThS4bSU/dLHFMKbEJmYIIxe0mRIY74bbzbRurnpUztwc1KA==";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }

    private static void m6_prd() throws Exception {
        String appKey = "20200904751512377878380544";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCPxjMd2arBNUYjXzBdjQxN7F2jntVV3ECE9LS11AFT+cy99wuXOAm5lPTo67Du3zBwiad3JXuz9Lwcn2HNkaxwHaSHILu8rQsyi8/cxdsylHGwxATSA0VtG2XdJDT6P3Vi5tkTosCanWbc+/+DvEeuxyYBDsOuqQfqimQn2HSU0WxP0z6HNwJkvXP9fF6KSGKZ/nWDA+YLsGumEXgi/sq83hirS2Pybmc5N7+VVk66UElHEZzSetSA/yBQpFnOW64YNPTTE3oN7eENYNbph4Ir5E6v6q+JlL0c2cQz5ugDycQMin+6Sp2qp4DU/mEuc3vWUO6WiGfyNLkvTs14Dt0NAgMBAAECggEAVdzVPDd5LafGOmuns8b/mS3XAldiKsO92GlX3ts868zcRHrcdjPmQum9lbjkUtQB1sOuuo4tIVzAVwusWhtscwyQ7I5U8Cob7NToj32uGbfjaeC2zEFd3folzHrKFMV/MlCRRZPGGNB11PW+NAtmd+/BN5J8tLuH2b9Kby1q+lBp4SrxIzXsJfYR2M6UlbGMYV8yzFRSgxkEKQRS6wThhvmGiUtuA3hQYeJxh/GlK/uOO6Vl707bZ4faoq7KblDLC+c/2H6XkopmDTM1SNKNkZLRMwUbtnVQoRk2pTAPjkcx+a0leYmxBqJ/cScZNx4aU8j9f/Az65ltGgGu8hCXNQKBgQDqqpXlr8X/tFObsY8tp8tiEmnog7Lh+DGIcJ20ni1D9KUwJj9c33WpevPcnBhpGOIQ9DIULRfKW0C9fFH9aIv5ULmwf/tBNBXKTEDXs6zKw/Zp/FQJxNfiSA3BX8su6ItFSwdBSQOj50hLr4sLdBSIXHip69UICSzrR2uvQPB0awKBgQCc2EWlMqBPp8WKoCE/HZ28/WwChNAu2aU8CFL5pe3j7IX5nlcnNAAgb5f8Qfy//aNKY1hlsaikXsVqk6MWLNHqImqLMhtGtBdBhvnE9TgmKQzVMcIgPAxPz4GmhbSsskJwBTWEym8FbgfhiaOJwIYRkiRKO8VUfckRJ8duYYGSZwKBgQDqbwDRNYjYq43bPMeNFNRaZYrofql2ljzl0Zu7lUojWYStVYh3f8ZMSkjVXBwG4pT12v8sqN/biM5kfo5qWsd7iun3KeQYf7BFKWieFSHKb3r85tgN6ljB9rnHNawGcMqxrwLQdeDtHWFcO0LtbkoU8EybdL6eCIyXgAJUUsvlgQKBgQCBVHRZO92k0Rq6rD+945Xl+LHPgeSIPT9auSJyaLg4cRgoNMB4uxA/rsUMZP0c8vBqrnB9qnj80IjI0ORxrJOLFMX18WM8cdObXMkn92xNSxwhz93a5qjgRqMJxMaugG74H9N5o9LYD1rARtZrCC2E35S9AXw9p1rcooh4JD7LkQKBgGGWFaRkBXPxjOgDO3Z0K/JnPjSjFPSMm99Vi/CiS0y61HKpn5J2/ATLiYg9mCQhkCvUH70Slyh4QTDlHhE/P0vIbFiUTfXTHkPuCTfAq6tZqOJJbKAj7ARUDC5R83emF+LpPZKfr7aT69S1f1B3yGMIv5nZH+21eGRs4fzkFc74";
        long timestamp = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder().append("appKey=" + appKey + "&")
                .append("signType=rsa2&")
                .append("timestamp=" + timestamp);
        System.out.println(timestamp);
        System.out.println(RsaUtil.sign(appKey, privateKey, timestamp));
    }
}
