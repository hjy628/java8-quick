package com.hjy.java8quick.chap2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hjy on 18-1-8.
 */
public class StreamReduceTest {

    public static void main(String[] args) {
        List integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(5);
        integers.add(8);
        Stream<Integer> values = integers.stream();


        Optional<Integer> sum = values.reduce((x,y)->x+y);

        values = integers.stream();
         Integer sums = values.reduce(0,(x,y)->x+y);

        values = integers.stream();
        Optional<Integer> sum1 = values.reduce(Integer::sum);


        String strings[] = new String[]{"dfsdfds","dfd","dfdegfg","Qfdegfg","QMMMfg","dfedcfrewewefr"};
        Stream<String> words = Stream.of(strings);
        int result = words.reduce(0,(total,word)->total+word.length(),(total1,total2)->total1+total2);

        words = Stream.of(strings);
        int result1 = words.mapToInt(String::length).sum();

        System.out.println(sum);
        System.out.println(sums);
        System.out.println(sum1);
        System.out.println(result);
        System.out.println(result1);


        Stream<String> stream = Stream.of(strings);
        HashSet<String> resultSet = stream.collect(HashSet::new,HashSet::add,HashSet::addAll);

        stream = Stream.of(strings);
        Set<String> resultSets = stream.collect(Collectors.toSet());

        stream = Stream.of(strings);
        List<String> restList = stream.collect(Collectors.toList());

        stream = Stream.of(strings);
        TreeSet<String> restTree = stream.collect(Collectors.toCollection(TreeSet::new));

        stream = Stream.of(strings);
        String restStr = stream.collect(Collectors.joining());

        stream = Stream.of(strings);
         stream.forEach(System.out::println);



    }


}
