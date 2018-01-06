package com.hjy.java8quick.chap1;

import java.util.Comparator;

/**
 * Created by hjy on 18-1-5.
 */
public class LengthComparator implements Comparator<String>{
    public int compare(String first, String second) {
        return Integer.compare(first.length(),second.length());
    }
}
