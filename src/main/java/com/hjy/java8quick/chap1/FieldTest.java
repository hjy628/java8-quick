package com.hjy.java8quick.chap1;

/**
 * Created by hjy on 18-1-5.
 */
public class FieldTest {

    public static void main(String[] args) {
        FieldTest.repeatMessage("Hello",1000);  //在另一个线程中打印Hello一千次
    }

    public static void repeatMessage(String text,int count){
        Runnable r = () ->{
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };

        new Thread(r).start();
    }


}
