/**
 * Created by hjy on 18-1-8.
 * java8的并发增强
 * 原子性. ConcurrentHashMap改进.  并行数组操作.  可完成的Future
 */
package com.hjy.java8quick.chap6;



        /**
         *   1.使用updateAndGet/accumulateAndGet方法可以更容易地更新原子变量
         *   2.在激烈的竞争环境下，LongAccumulator/DoubleAccumulator比AtomicLong/AtomicDouble效率更高
         *   3.使用compute和merge方法可以更容易地更新ConcurrentHashMap中的元素项目
         *   4.现在，ConcurrentHashMap提供了对键、值、键值对及元素项的各类操作,如search、reduce和forEach.
         *   5.集合视图允许你将ConcurrentHashMap作为一个Set来使用
         *   6.Arrays类提供了排序、填充及前缀操作的并行方法
         *   7.完善的Future类允许你创建异步的操作
         */