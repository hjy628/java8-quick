package com.hjy.java8quick.chap1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by hjy on 18-1-6.
 */
public class PathFileTest {

    public static void main(String[] args) throws Exception{

        String contents = new String(Files.readAllBytes(Paths.get("Message.txt")), StandardCharsets.UTF_8); //将文字读入到字符串中

        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        //将字符串分割为单词，非子母被认为是分隔符

        int count = 0;
        for (String w :
                words) {
            if (w.length()>2) count++;
         }

         long ccc = words.stream().filter(w->w.length()>2).count();

        Stream<String> wor = Stream.of(contents.split("[\\P{L}]+"));
        //split方法会返回一个String[]数组

    }


}
