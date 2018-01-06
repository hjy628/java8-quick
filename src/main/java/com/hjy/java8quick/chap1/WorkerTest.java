package com.hjy.java8quick.chap1;

/**
 * Created by hjy on 18-1-5.
 */
public class WorkerTest {

    public static void main(String[] args) {

        Worker worker = new Worker();
        new Thread(worker).start();
    }


}
