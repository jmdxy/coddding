package com.mycode;

import java.util.Random;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(1 << 31);

        Random ran = new Random(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.abs(ran.nextInt()) % 100);
        }

        int start = 1;
        int end = 8;
        System.out.println((start + end) / 2);
        System.out.println((start + end) >>> 1);
        System.out.println((start + end) << 1);

        System.out.println((Integer.MAX_VALUE + 1) & (1 << 31)); //-2147483648
        System.out.println((Integer.MAX_VALUE) & (1 << 31)); //0
        System.out.println((Integer.MIN_VALUE >> 31) & 1); //1
        System.out.println((Integer.MIN_VALUE >> 32) & 1); //0
        System.out.println((Integer.MIN_VALUE >>> 31) & 1); //1
        System.out.println((Integer.MIN_VALUE >>> 32) & 1); //0
    }

}
