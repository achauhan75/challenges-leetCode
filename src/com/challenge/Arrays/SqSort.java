package com.challenge.Arrays;

import java.util.Arrays;

public class SqSort {
    public static int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
           A[i] =  A[i]* A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        System.out.println(sortedSquares(arr));
    }
}
