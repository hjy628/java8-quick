package com.hjy.java8quick.chap6;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by hjy on 18-1-8.
 */
public class ArraysTest {

    public static void main(String[] args) throws Exception{

        String contents = new String(Files.readAllBytes(Paths.get("test.txt")), StandardCharsets.UTF_8);    //将文件内容读取到字符串中
        String[] words = contents.split("[\\P{L}]+");   //根据非字母字符对字符串进行分割
        Arrays.parallelSort(words);
        Arrays.parallelSort(words,words.length/2,words.length); //对上半部分排序

    }


}
