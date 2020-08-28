package com.study.util.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapTest {
    public static void main(String[] args) {
        List<SupplierAccount> accounts = buildList();
//        Map<String, List<SupplierAccount>> accountMap = accounts.stream().collect(Collectors.groupingBy(supplierAccount -> supplierAccount.getBeneficiaryId() + ":" + supplierAccount.getCurrency(),
//                Collectors.mapping(Function.identity(), Collectors.toList())));

        Map<String, List<SupplierAccount>> accountMap = accounts.stream().collect(Collectors.groupingBy(supplierAccount -> supplierAccount.getBeneficiaryId() + ":" + supplierAccount.getCurrency(),
                Collectors.toList()));
        System.out.println(accountMap);
    }

    private static List<SupplierAccount> buildList() {
        SupplierAccount account1 = new SupplierAccount();
        account1.setBeneficiaryId(12L);
        account1.setCurrency("US");
        account1.setBusiId("1");
        account1.setAccType("1");
        account1.setFreezeAmt(new BigDecimal("10"));
        account1.setAccBal(new BigDecimal("10"));

        SupplierAccount account2 = new SupplierAccount();
        account2.setBeneficiaryId(12L);
        account2.setCurrency("US");
        account2.setBusiId("1");
        account2.setAccType("2");
        account2.setFreezeAmt(new BigDecimal("20"));
        account2.setAccBal(new BigDecimal("20"));

        SupplierAccount account3 = new SupplierAccount();
        account3.setBeneficiaryId(12L);
        account3.setCurrency("RM");
        account3.setBusiId("1");
        account3.setAccType("1");
        account3.setFreezeAmt(new BigDecimal("30"));
        account3.setAccBal(new BigDecimal("30"));

        SupplierAccount account4 = new SupplierAccount();
        account4.setBeneficiaryId(20L);
        account4.setCurrency("US");
        account4.setBusiId("1");
        account4.setAccType("1");
        account4.setFreezeAmt(new BigDecimal("40"));
        account4.setAccBal(new BigDecimal("40"));

        return Arrays.asList(account1, account2, account3, account4);
    }

    private static class SupplierAccount {
        private Long beneficiaryId;
        private String currency;
        private String busiId;
        private String accType;
        private BigDecimal freezeAmt;
        private BigDecimal accBal;

        public Long getBeneficiaryId() {
            return beneficiaryId;
        }

        public void setBeneficiaryId(Long beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getBusiId() {
            return busiId;
        }

        public void setBusiId(String busiId) {
            this.busiId = busiId;
        }

        public String getAccType() {
            return accType;
        }

        public void setAccType(String accType) {
            this.accType = accType;
        }

        public BigDecimal getFreezeAmt() {
            return freezeAmt;
        }

        public void setFreezeAmt(BigDecimal freezeAmt) {
            this.freezeAmt = freezeAmt;
        }

        public BigDecimal getAccBal() {
            return accBal;
        }

        public void setAccBal(BigDecimal accBal) {
            this.accBal = accBal;
        }

        @Override
        public String toString() {
            return "SupplierAccount{" +
                    "beneficiaryId=" + beneficiaryId +
                    ", currency='" + currency + '\'' +
                    ", busiId='" + busiId + '\'' +
                    ", accType='" + accType + '\'' +
                    ", freezeAmt=" + freezeAmt +
                    ", accBal=" + accBal +
                    '}';
        }
    }
}
