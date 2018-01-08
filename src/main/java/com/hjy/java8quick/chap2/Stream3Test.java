package com.hjy.java8quick.chap2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by hjy on 18-1-8.
 */
public class Stream3Test {

    public static void main(String[] args) {

        IntStream stream = IntStream.of(1,1,2,3,5,6,8);
        int[] values = {1,3,4,5,76,9,7,2,6};
        stream = Arrays.stream(values,0,8);

        IntStream zeroToNinetyNine = IntStream.range(0,100);    //不包括上限
        IntStream zeroToHundred = IntStream.rangeClosed(0,100); //包括上限




    }


}
