package com.hjy.java8quick.chap9;

import java.nio.file.Paths;

/**
 * Created by hjy on 18-1-9.
 */
public class ProcessBuilderTest {


    public static void main(String[] args) throws Exception{

        ProcessBuilder builder = new ProcessBuilder("grep","-o","[A-Za-z_][A-Za-z_0-9]*");

        builder.redirectInput(Paths.get("/home/hjy/out.log").toFile());
        builder.redirectOutput(Paths.get("/home/hjy/out.txt").toFile());


        Process process = builder.start();

        process.waitFor();


        //ls命令的输出会被发送到System.out
        ProcessBuilder builder1 = new ProcessBuilder("ls","-al");
        builder1.inheritIO();
        builder1.start().waitFor();


    }


}
