package com.study.jdkdemo.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.util.StopWatch;

public class PeekTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "dd", "ee");
        StopWatch sw = new StopWatch("stopwatch");
        list.stream().parallel()
                .peek(s -> sw.start(s))
                .filter(s -> {
                    try {
                        TimeUnit.SECONDS.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.length() > 1;
                })
                .peek(s -> sw.stop())
                //.peek(s -> System.out.println("step2:" + s))
                .map(s -> "m_" + s)
                .collect(toList());
        System.out.println(sw.prettyPrint());
    }
}
