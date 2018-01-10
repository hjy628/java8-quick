package com.hjy.java8quick.chap3;

import java.util.function.IntConsumer;

/**
 * Created by hjy on 18-1-9.
 */
public class LambdaParamTest {

    public static void main(String[] args) {
        repeat(10,i-> System.out.println("Countdown: "+(9-i)));
    }


    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }


}
