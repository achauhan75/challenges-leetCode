package com.challenge.JuneChallenge;

import static java.lang.Math.floor;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
       System.out.println(isPowerOfTwo(536870912));
       System.out.println(isPowerOfTwo(256));
       System.out.println(isPowerOfTwo(-2147483648));
    }
}
