package com.hjy.java8quick.chap1;

/**
 * Created by hjy on 18-1-5.
 */
public interface Person {

    long getId();

    default String getName(){return "HJY";}

}
