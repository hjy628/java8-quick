package com.hjy.java8quick.chap9;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by hjy on 18-1-9.
 */
public class PathTest {

    public static void main(String[] args) throws Exception{

        Path absolute = Paths.get("/","home","hjy");
        Path relative = Paths.get("tmp","conf","user.properties");
        Path homeDirectory = Paths.get("/home/hjy");


        byte[] bytes = Files.readAllBytes(relative);

        String content = new String(bytes, StandardCharsets.UTF_8);

        List<String> lines = Files.readAllLines(relative);

        Files.write(relative,content.getBytes(StandardCharsets.UTF_8));

        Files.write(relative,lines);

        Files.write(relative,lines, StandardOpenOption.APPEND);

        InputStream in = Files.newInputStream(relative);

        OutputStream out = Files.newOutputStream(relative);

        Reader reader = Files.newBufferedReader(relative);

        Writer writer = Files.newBufferedWriter(relative);

        Files.copy(in,relative);

        Files.copy(relative,out);

        //创建新目录
        Files.createDirectory(absolute);

        //同时创建中间目录
        Files.createDirectories(relative);


        //创建空文件
        Files.createFile(relative);


        Path fromPath = Paths.get("/home/hjy/work/from");
        Path toPath = Paths.get("/home/hjy/work/to");


        Files.copy(fromPath,toPath, StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);

        Files.move(fromPath,toPath,StandardCopyOption.ATOMIC_MOVE);

        Files.delete(relative);

        boolean deleted = Files.deleteIfExists(relative);

        Logger.global.finest("test");


    }



}
