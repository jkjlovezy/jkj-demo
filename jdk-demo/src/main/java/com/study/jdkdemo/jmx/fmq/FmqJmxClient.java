package com.study.jdkdemo.jmx.fmq;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;


public class FmqJmxClient {
    static String MESSAGE_IN_PER_SEC = "kafka.server:type=BrokerTopicMetrics,name=MessagesInPerSec";

    public static void main(String[] args) throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.63.64:9096/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        StopWatch sw = new StopWatch("---monitor----");
        sw.start("----getAndCreateBrokerMbeanData2");
        for(int i=0;i<1;i++) {
            MbeanData mbeanData = getAndCreateBrokerMbeanData2(mbsc, "skywalking_segments_usa");
            //System.out.println(JSON.toJSONString(mbeanData));
        }
        sw.stop();

        sw.start("----getAndCreateBrokerMbeanData");
        for(int i=0;i<1;i++) {
            MbeanData mbeanData = getAndCreateBrokerMbeanData(mbsc, "skywalking_segments_usa");
            //System.out.println(JSON.toJSONString(mbeanData));
        }
        sw.stop();


        System.out.println(sw.prettyPrint());
        jmxc.close();
    }

    private static MbeanData getAndCreateBrokerMbeanData(MBeanServerConnection mbsc, String topic) {
        ObjectName objectName = getObjectNameWithTopic(MESSAGE_IN_PER_SEC, topic);
        System.out.println(objectName);
        MbeanData mbeanData = new MbeanData(objectName);
        try {
            if (Objects.nonNull(mbsc)) {
                mbeanData.setCount(mbsc.getAttribute(objectName, "Count"));
                mbeanData.setEventType(mbsc.getAttribute(objectName, "EventType"));
                mbeanData.setOneMinuteRate(mbsc.getAttribute(objectName, "OneMinuteRate"));
                mbeanData.setFiveMinuteRate(mbsc.getAttribute(objectName, "FiveMinuteRate"));
                mbeanData.setFifteenMinuteRate(mbsc.getAttribute(objectName, "FifteenMinuteRate"));
                mbeanData.setRateUnit(mbsc.getAttribute(objectName, "RateUnit"));
                mbeanData.setMeanRate(mbsc.getAttribute(objectName, "MeanRate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mbeanData;
    }

    private static MbeanData getAndCreateBrokerMbeanData2(MBeanServerConnection mbsc, String topic) {
        ObjectName objectName = getObjectNameWithTopic(MESSAGE_IN_PER_SEC, topic);
        MbeanData mbeanData = new MbeanData(objectName);
        try {
            if (Objects.nonNull(mbsc)) {
                AttributeList attributes = mbsc.getAttributes(objectName, new String[]{"Count", "EventType", "OneMinuteRate", "FiveMinuteRate", "FifteenMinuteRate", "RateUnit", "MeanRate"});
                Map<String, Object> attributeMap = attributes.asList().stream().collect(Collectors.toMap(Attribute::getName, Attribute::getValue));
                mbeanData.setCount(attributeMap.get("Count"));
                mbeanData.setEventType(attributeMap.get("EventType"));
                mbeanData.setOneMinuteRate(attributeMap.get("OneMinuteRate"));
                mbeanData.setFiveMinuteRate(attributeMap.get("FiveMinuteRate"));
                mbeanData.setFifteenMinuteRate(attributeMap.get("FifteenMinuteRate"));
                mbeanData.setRateUnit(attributeMap.get("RateUnit"));
                mbeanData.setMeanRate(attributeMap.get("MeanRate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mbeanData;
    }

    private static ObjectName getObjectNameWithTopic(String mbeanName, String topic) {
        ObjectName objectName = null;
        try {
            if (isNotBlank(topic)) {
                return new ObjectName(mbeanName + ",topic=" + topic);
            }
            return new ObjectName(mbeanName);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
            return null;
        }

    }
}
