package com.challenge.JuneChallenge;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and
 * you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
public class CheckSubsequence {
    private static boolean isSubsequence(String s, String t) {
        int j = 0;
        int n = t.length();
        int m = s.length();
        for (int i = 0; i < n && j < m; i++)
            if (s.charAt(j) == t.charAt(i))
                j++;
        return (j == m);
    }

    public static void main(String[] args) {
        String x = "abc";
        String y = "asdjbskowkoc";
        System.out.println(isSubsequence(x, y));
    }
}
