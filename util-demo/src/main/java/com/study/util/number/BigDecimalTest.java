package com.study.util.number;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static BigDecimal divide(BigDecimal divisor, BigDecimal divide, int pos, int round) {
        if (divisor != null && divide != null) {
            return divisor.divide(divide, pos, round).setScale(pos, round);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(divide(new BigDecimal(100),new BigDecimal(3),2,BigDecimal.ROUND_DOWN));
    }
}
