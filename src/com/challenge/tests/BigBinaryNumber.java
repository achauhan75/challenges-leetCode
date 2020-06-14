package com.challenge.tests;

public class BigBinaryNumber {

    private static double bigBinaryNumber(Integer n) {
        String s = "";
        for(int i=1; i<=n; i++){
             s = s + Integer.toBinaryString(i);
        }
        System.out.println(s);
        return Long.parseLong(s) % (Math.pow(10,9)+7);
    }

    public static void main(String[] args){
        System.out.println(bigBinaryNumber(3));
    }
}
