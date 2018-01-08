package com.hjy.java8quick.chap6;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by hjy on 18-1-8.
 */
public class ConcurrentHashMapTest {


    /**
     *  某些应用程序需要使用数量巨大的并发哈希映射，其元素数量之大，以至于size方法已经不够用了
     *  (因为size方法返回的是int值)
     * 　如何处理一个含有超过两百万个数据项的映射呢?　java8引入了一个mappingCount方法，用来返回一个反映大小的long型值
     *
     *
     */


    public static void main(String[] args) {
        ConcurrentHashMap<String,LongAdder> map = new ConcurrentHashMap<>();
        String word = "test";
        map.putIfAbsent(word,new LongAdder()).increment();



    }





}
