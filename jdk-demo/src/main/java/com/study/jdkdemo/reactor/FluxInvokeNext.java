package com.study.jdkdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class FluxInvokeNext {
    public static void main(String[] args) {
        /*Flux.fromIterable(Arrays.asList("a", "b", "c"))
                .concatMap(s -> {
                    if ("a".equals(s))
                        return Mono.empty();
                    return Mono.just(s + "_concatstr");
                })
                .next()
                .flatMap(FluxInvokeNext::query)
                .flatMap(s -> Mono.just(s)).subscribe();*/

        Flux.fromIterable(Arrays.asList("a", "b", "c"))
                .concatMap(s -> {
                    if ("a".equals(s))
                        return Mono.empty();
                    return Mono.just(s + "_concatstr");
                }).map(s -> {
            System.out.println(" map: "+s);
            return s;
        }).subscribe();
    }


    static Mono<String> query(String s) {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Thread id:{%s}, Thread name:{%s}, value:{%s}, used ms:{%s}",
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                s,
                1000)
        );
        return Mono.just(s);
    }
}
