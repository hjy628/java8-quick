package com.hjy.java8quick.chap2;

import java.util.Optional;

/**
 * Created by hjy on 18-1-8.
 */
public class OptionTest {

    public static void main(String[] args) {

        //Optional<T>如果存在被封装的对象，那么get()方法会返回该对象,否则会抛出一个NoSushElementException.因此
        //Optional optionalValue = ...;
        //optionalValue.get().someMethod();
        //并不比下面的方式更安全
        //T value = ...
        //value.someMethod;

        //if(optionalValue.isPresent()) optionalValue.someMethod();并不比if(value!=null) value.someMethod();更简单

        //高效使用Optional的关键在于:使用一个或者接收正确值、或者返回另一个替代值的方法
        //isPresent方法的另一种形式可以接受一个函数
        //optionalValue.ifPresent(v->Process(V));
        //optionalValue.ifPresent(results::add);

        Double x = 100D;

        Optional<Double> result = inverse(x).flatMap(OptionTest::squareRoot);
        Optional<Double> result1 = Optional.of(-4.0).flatMap(OptionTest::inverse).flatMap(OptionTest::squareRoot);


    }

    public static Optional<Double> inverse(Double x){
        return x==0?Optional.empty():Optional.of(1/x);
    }

    public static Optional<Double> squareRoot(Double x){
        return x<0?Optional.empty():Optional.of(Math.sqrt(x));
    }


}
