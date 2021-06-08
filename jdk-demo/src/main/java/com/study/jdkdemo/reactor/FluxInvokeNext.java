package com.study.jdkdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;

public class FluxInvokeNext {
    public static void main(String[] args) throws IOException {
        Flux.fromIterable(Arrays.asList("a", "b", "c"))
                .log()
                .concatMap(s -> {
                    if ("a".equals(s))
                        return Mono.empty();
                    return Mono.just(s + "_concatstr");
                })
                .next()
                .flatMap(FluxInvokeNext::query)
                .flatMap(s -> Mono.just(s)).subscribe();
        System.in.read();

        /*Flux.fromIterable(Arrays.asList("a", "b", "c"))
                .log()
                .concatMap(s -> {
                    if ("a".equals(s))
                        return Mono.empty();
                    return Mono.just(s + "_concatstr");
                }).map(s -> {
            System.out.println(" map: " + s);
            return s;
        }).subscribe(System.out::println);*/
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
