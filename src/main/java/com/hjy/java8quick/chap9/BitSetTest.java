package com.hjy.java8quick.chap9;

import java.util.BitSet;

/**
 * Created by hjy on 18-1-9.
 */
public class BitSetTest {

    public static void main(String[] args) {

        byte[] bytes = {(byte)0b10101100,(byte)0b00101000};

        BitSet primes = BitSet.valueOf(bytes);
        //{2,3,5,7,11,13}

        long[] longs = {0x100010116L,0x1L,0x1L,0x1L,0L,0x1L};

        BitSet powersOfTwo = BitSet.valueOf(longs);
        //{1,2,4,8,16,32,64,128,256}

        //如果要获得对应的引用类型，则调用方法为toByteArray和toLongArray
        byte[] bytes1 = powersOfTwo.toByteArray();
        //[0b00010110,1,1,0,1,0,0,0,1,...]

    }



}
