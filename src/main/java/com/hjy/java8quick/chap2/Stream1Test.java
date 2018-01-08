package com.hjy.java8quick.chap2;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by hjy on 18-1-8.
 */
public class Stream1Test {

    public static void main(String[] args) {

        //peek方法会产生另一个与原始流具有相同元素的流，但是在每次获取一个元素时，都会调用一个函数，这样便于调试
        //当真正访问某个元素时会打印一条消息,通过这种方式，你可以确定iterate方法返回的无限流是否被延迟处理了
        Object[] powers = Stream.iterate(1.0,p->p*2).peek(e-> System.out.println("Fetching "+e)).limit(20).toArray();

        System.out.println("-----------------------------");
        //有状态的转换
        Stream<String> uniqueWords = Stream.of("merrily","merrily","merrily","gently").distinct();
        uniqueWords.forEach(e-> System.out.println(e));
        //只获取了一个"merrily"

        System.out.println("-----------------------------");

        String strings[] = new String[]{"dfsdfds","dfd","dfdegfg","Qfdegfg","QMMMfg","dfedcfrewewefr"};
        Stream<String> words = Stream.of(strings);
        Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
        longestFirst.forEach(e-> System.out.println(e));

        System.out.println("-----------------------------");
        words = Stream.of(strings);
        Optional<String> largest = words.max(String::compareToIgnoreCase);
        if (largest.isPresent()){
            System.out.println("largest: "+largest.get());
        }
        words = Stream.of(strings);
        Optional<String> startsWithQ = words.filter(s->s.startsWith("Q")).findFirst();
        if (startsWithQ.isPresent()){
            System.out.println("startsWithQ: "+startsWithQ.get());
        }
        words = Stream.of(strings);
        Optional<String> startsWithQAny = words.filter(s->s.startsWith("Q")).findAny();
        if (startsWithQAny.isPresent()){
            System.out.println("startsWithQAny: "+startsWithQAny.get());
        }
        words = Stream.of(strings);
        boolean aWordStartsWithQ = words.parallel().anyMatch(s->s.startsWith("Q"));

    }






}
