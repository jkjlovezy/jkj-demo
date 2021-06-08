package com.study.jdkdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class FluxOperatorTest {
    public static void main(String[] args) {
        //log();
        //log2();
        //then();
        //thenMany();
        // when();
        //merge();
        zip();
        zipWith();
        zipWith2();
        //concat();
        //reduce();
        //reduceWith();
    }

    /**
     * 元素并未生成
     */
    static void log() {
        Flux.just(1, 2, 3)
                .log();
    }

    /**
     * 元素进行了生成。
     */
    static void log2() {
        Flux.just(1, 2, 3)
                .log()
                .subscribe();
    }

    /**
     * then 操作符的含义是等到上一个操作完成再进行下一个。
     * 这里尽管生成了一个包含 1、2、3 三个元素的 Flux 流，但 then 操作符在上游的元素执行完成之后才会触发新的数据流，也就是说会忽略所传入的元素，所以上述代码在控制台上实际并没有任何输出。
     * 输出空
     */
    static void then() {
        Flux.just(1, 2, 3)
                .log()
                .then()
                .subscribe(System.out::println);
    }

    /**
     * 和 then 一起的还有一个 thenMany 操作服务，具有同样的含义，但可以初始化一个新的 Flux 流。示例代码如下所示，这次我们会看到控制台上输出了 4 和 5 这两个元素
     * 输出 4 5
     */
    static void thenMany() {
        Flux.just(1, 2, 3)
                .log()
                .thenMany(Flux.just(4, 5).log())
                .subscribe(System.out::println);
    }

    static void when() {
        Mono.when(Flux.just(1, 2, 3).log(), Flux.just(4, 5, 6).log().then(Mono.justOrEmpty(7)), Flux.just(11, 12, 13).log(), Flux.just(21, 22, 23).log()).subscribe();
    }

    /**
     * merge 操作符用来把多个 Flux 流合并成一个 Flux 序列，而合并的规则就是按照流中元素的实际生成的顺序进行。
     * 输出 0 0 1 1 2 2
     */
    static void merge() {
        Flux.merge(
                Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(3),
                Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(3)
        ).toStream().forEach(System.out::println);
    }

    /**
     * zip将当前流中的元素与另外一个流中的元素按照一对一的方式进行合并,得到一个元素类型为 Tuple2 的流
     * 输出 [1,4] [2,5] [3,6]
     */
    static void zip() {
        Flux.zip(
                Flux.just(1, 2, 3),
                Flux.just(4, 5, 6)
        ).subscribe(System.out::println);
    }

    /**
     * zipWith实现效果同zip
     * 输出[1,3] [2,4]
     */
    static void zipWith() {
        Flux.just(1, 2)
                .zipWith(
                        Flux.just(3, 4)
                )
                .subscribe(System.out::println);

    }

    /**
     * zipWith还可以通过BiFunction函数，对合并过程进行精细化的处理
     * 输出 1+3=4,  2+4=6
     */
    static void zipWith2() {
        Flux.just(1, 2)
                .zipWith(
                        Flux.just(3, 4),
                        (s1, s2) -> String.format("%s + %s = %s", s1, s2, s1 + s2)
                )
                .subscribe(System.out::println);

    }

    /**
     * concat 与merge不同，合并采用的顺序的方式，Flux序列的元素全部生成后 再拼接下一个Flux序列的全部元素
     * 输出 0 1 2 0 1 2
     */
    static void concat() {
        Flux.concat(
                Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(3),
                Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(3)
        ).toStream().forEach(System.out::println);
    }

    /**
     * reduce 操作符对来自 Flux 序列中的所有元素进行累积操作并得到一个 Mono 序列，该 Mono 序列中包含了最终的计算结果
     * 输出 55
     */
    static void reduce() {
        Flux.range(1, 10).reduce((x, y) -> x + y).subscribe(System.out::println);
    }

    /**
     * 用来在 reduce 操作时指定一个初始值。
     * 输出 155
     */
    static void reduceWith() {
        Flux.range(1, 10).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
    }
}
