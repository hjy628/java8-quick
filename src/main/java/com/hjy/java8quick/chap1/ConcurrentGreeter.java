package com.hjy.java8quick.chap1;

/**
 * Created by hjy on 18-1-5.
 */
public class ConcurrentGreeter extends Greeter{

    public static void main(String[] args) {
        ConcurrentGreeter greeter = new ConcurrentGreeter();
        greeter.greet();
    }

    @Override
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}
