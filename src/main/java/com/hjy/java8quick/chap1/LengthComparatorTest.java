package com.hjy.java8quick.chap1;

import java.util.Arrays;

/**
 * Created by hjy on 18-1-5.
 */
public class LengthComparatorTest {

    public static void main(String[] args) {
        String strings[] = new String[]{"dfsdfds","dfd","dfdegfg","dfedcfrewewefr"};
        Arrays.sort(strings,new LengthComparator());
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
