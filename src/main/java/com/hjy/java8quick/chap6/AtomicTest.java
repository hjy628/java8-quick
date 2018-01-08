package com.hjy.java8quick.chap6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by hjy on 18-1-8.
 */
public class AtomicTest {

    public static AtomicLong nextNumber = new AtomicLong();
    public static AtomicLong largest = new AtomicLong();


    public static void main(String[] args) {
        //在某些线程中...
        long id = nextNumber.incrementAndGet();     //值加1并返回增加后的值


        long oldVaule,newValue;
        long observed = 203l;

        do {
            oldVaule = largest.get();
            newValue = Math.max(oldVaule,observed);
        }while (!largest.compareAndSet(oldVaule,newValue));

        largest.updateAndGet(x->Math.max(x,observed));

        largest.accumulateAndGet(observed,Math::max);



        final LongAdder adder = new LongAdder();
   /*
        for (...)
            pool.submit(()->{
                while (...){
                    ...
                    if (...) {
                        adder.increment();
                    }
                }
            });
*/

   long total = adder.sum();


        LongAccumulator adder2 = new LongAccumulator(Long::sum,0);
        //在某些线程中...
        adder2.accumulate(121);


    }




}
