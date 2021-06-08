package com.study.jdkdemo.jmx.fmq;

import java.util.concurrent.TimeUnit;

import javax.management.ObjectName;

/**
 * @author dingjinlong
 * @date 2018/8/22
 */
public class MbeanData {
    private long count = 0L;
    private String eventType = "";
    private double oneMinuteRate = 0;
    private double fiveMinuteRate = 0;
    private TimeUnit rateUnit = TimeUnit.SECONDS;
    private double meanRate = 0;
    private double fifteenMinuteRate = 0;
    private ObjectName objectName;

    public String getShowOneMinuteRate() {
        return String.valueOf(this.oneMinuteRate);
    }

    public String getShowFiveMinuteRate() {
        return String.valueOf(this.fiveMinuteRate);
    }

    public String getShowFifteenMinuteRate() {
        return String.valueOf(this.fifteenMinuteRate);
    }

    public String getShowMeanRate() {
        return String.valueOf(this.meanRate);
    }

    public String getOneMinuteRateStr() {
        return String.valueOf(this.oneMinuteRate);
    }

    public String getFiveMinuteRateStr() {
        return String.valueOf(this.fiveMinuteRate);
    }

    public String getFifteenMinuteRateStr() {
        return String.valueOf(this.fifteenMinuteRate);
    }

    public String getMeanRateStr() {
        return String.valueOf(this.meanRate);
    }

    public String getCountStr() {
        return String.valueOf(count);
    }


    public MbeanData(ObjectName objectName) {
        this.objectName = objectName;
    }

    public ObjectName getObjectName() {
        return objectName;
    }

    public void setObjectName(ObjectName objectName) {
        this.objectName = objectName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(Object count) {
        if (count != null) {
            this.count = ((Long) count).longValue();
        }
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(Object eventType) {
        if (eventType != null) {
            this.eventType = (String) eventType;
        }
    }

    public double getOneMinuteRate() {
        return oneMinuteRate;
    }

    public void setOneMinuteRate(Object oneMinuteRate) {
        if (oneMinuteRate != null) {
            this.oneMinuteRate = ((Double) oneMinuteRate).doubleValue();
        }
    }

    public double getFiveMinuteRate() {
        return fiveMinuteRate;
    }

    public void setFiveMinuteRate(Object fiveMinuteRate) {
        if (fiveMinuteRate != null) {
            this.fiveMinuteRate = ((Double) fiveMinuteRate).doubleValue();
        }
    }

    public TimeUnit getRateUnit() {
        return rateUnit;
    }

    public void setRateUnit(Object rateUnit) {
        if (rateUnit != null) {
            this.rateUnit = (TimeUnit) rateUnit;
        }
    }

    public double getMeanRate() {
        return meanRate;
    }

    public void setMeanRate(Object meanRate) {
        if (meanRate != null) {
            this.meanRate = ((Double) meanRate).doubleValue();
        }
    }

    public double getFifteenMinuteRate() {
        return fifteenMinuteRate;
    }

    public void setFifteenMinuteRate(Object fifteenMinuteRate) {
        if (fifteenMinuteRate != null) {
            this.fifteenMinuteRate = ((Double) fifteenMinuteRate).doubleValue();
        }
    }

    public MbeanData addMbeanData(MbeanData mbeanData) {
        this.eventType = mbeanData.eventType;
        this.count += mbeanData.getCount();
        this.oneMinuteRate += mbeanData.getOneMinuteRate();
        this.fiveMinuteRate += mbeanData.getFiveMinuteRate();
        this.fifteenMinuteRate += mbeanData.getFifteenMinuteRate();
        this.meanRate += mbeanData.getMeanRate();
        return this;
    }
}
