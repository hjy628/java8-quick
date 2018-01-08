package com.hjy.java8quick.chap6;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by hjy on 18-1-8.
 */
public class Vector {


    /**
     *  java8中还添加了一个StampedLock类，它用来实现乐观读
     *  首先调用tryOptimisticRead方法，此时你会获得一个"印戳",然后你读取值并检查"印戳"是否仍然有效(例如，没有其他线程已经获得了一个写锁)
     *  如果有效，你就可以使用这个值;如果无效，你会获得一个读锁(它将会阻塞所有的写锁)
     *
     */


    private int size;

    private Object[] elements;

    private StampedLock lock = new StampedLock();

    public Object get(int n){
        long stamp = lock.tryOptimisticRead();
        Object[] currentElements = elements;

        int currentSize = size;

        if (!lock.validate(stamp)){ //某个线程持有了一个写锁
            stamp = lock.readLock();    //获得一个悲观锁
            currentElements = elements;
            currentSize = size;
            lock.unlockRead(stamp);
        }

        return n<currentSize?currentElements[n]:null;

    }



}
