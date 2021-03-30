package com.study.jdkdemo.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(Arrays.asList("a","b")).orElseGet(ArrayList::new));
        List<Stock> list = new ArrayList<>();
        list.add(new Stock(1L,111L));
        list.add(new Stock(2L,222L));
        list.add(new Stock(3L,222L));
        list.add(new Stock(4L,333L));
        Stock selected = list.stream().filter(stock->stock.getRegionId().equals(334L)).findFirst().orElse(list.get(0));
        System.out.println(selected);
    }

    static class Stock{
        private Long stockId;
        private Long regionId;

        public Stock(Long stockId, Long regionId) {
            this.stockId = stockId;
            this.regionId = regionId;
        }

        public Long getStockId() {
            return stockId;
        }

        public void setStockId(Long stockId) {
            this.stockId = stockId;
        }

        public Long getRegionId() {
            return regionId;
        }

        public void setRegionId(Long regionId) {
            this.regionId = regionId;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "stockId=" + stockId +
                    ", regionId=" + regionId +
                    '}';
        }
    }
}
