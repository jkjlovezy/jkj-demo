package com.study.util.swap;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

public class SwapTest {
    public static void main(String[] args) {
        List<Region> regionList = new ArrayList<>();
        regionList.add(new Region(3L, "a"));
        regionList.add(new Region(4L, "a"));
        regionList.add(new Region(5L, "a"));

        regionList.stream().forEach(System.out::println);
        sortRegionList(regionList);
        System.out.println("after sort -----------");
        regionList.stream().forEach(System.out::println);
    }

    static void sortRegionList(List<Region> sourceList) {
        if (isEmpty(sourceList)) {
            return;
        }
        sourceList.stream().filter(source -> source.getRegionId().equals(5L)).findFirst().ifPresent(usaRegion -> {
            sourceList.remove(usaRegion);
            sourceList.add(0, usaRegion);
        });

    }

    static class Region {
        private Long regionId;
        private String regionName;

        public Region(Long regionId, String regionName) {
            this.regionId = regionId;
            this.regionName = regionName;
        }

        public Long getRegionId() {
            return regionId;
        }

        public void setRegionId(Long regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "regionId=" + regionId +
                    ", regionName='" + regionName + '\'' +
                    '}';
        }
    }
}
