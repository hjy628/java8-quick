package com.hjy.java8quick.chap1;

/**
 * Created by hjy on 18-1-5.
 */
public class Worker implements Runnable{
    public void run() {
        for (int i = 0; i < 1000; i++) {
            doWork();
        }
    }


    private void doWork(){
        System.out.println(Thread.currentThread().getName());
    }

}
