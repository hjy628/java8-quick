package com.hjy.java8quick.chap8;

import java.time.ZoneId;

/**
 * Created by hjy on 18-1-8.
 */
public class StringTest {

    public static void main(String[] args) {
        String joined = String.join("/","usr","local","bin");
        System.out.println(joined);

        String ids = String.join(",", ZoneId.getAvailableZoneIds());
        System.out.println(ids);


    }

}
