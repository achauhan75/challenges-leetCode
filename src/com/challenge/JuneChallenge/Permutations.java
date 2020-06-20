package com.challenge.JuneChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class Permutations {

    public String getPermutation(int n, int k) {
        List<String> nums = new ArrayList();
        String ans = "";
        for(int i = 1; i<n+1;i++){
            nums.add(Integer.toString(i));
        }
        while(!nums.isEmpty()){

            int fac = factorial(--n);

            int div = k/fac;
            k=k%fac;
            if(k>0){
                ans+=nums.remove(div);
            }else{
                ans+=nums.remove(div-1);
                k=fac;
            }

        }
        return ans;
    }
    public int factorial(int n){
        int ans = 1;
        for(int i = 1; i<n+1;i++){
            ans*=i;
        }
        return ans;
    }
}
