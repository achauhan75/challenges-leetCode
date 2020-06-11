package com.challenge.JuneChallenge;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortedColor {
        void merge(int[] arr, int beg,
                   int mid, int end,
                   int maxele)
        {
            int i = beg;
            int j = mid + 1;
            int k = beg;
            while (i <= mid && j <= end)
            {
                if (arr[i] % maxele <=
                        arr[j] % maxele)
                {
                    arr[k] = arr[k] + (arr[i]
                            % maxele) * maxele;
                    k++;
                    i++;
                }
                else
                {
                    arr[k] = arr[k] +
                            (arr[j] % maxele)
                                    * maxele;
                    k++;
                    j++;
                }
            }
            while (i <= mid)
            {
                arr[k] = arr[k] + (arr[i]
                        % maxele) * maxele;
                k++;
                i++;
            }
            while (j <= end)
            {
                arr[k] = arr[k] + (arr[j]
                        % maxele) * maxele;
                k++;
                j++;
            }

            // Obtaining actual values
            for (i = beg; i <= end; i++)
            {
                arr[i] = arr[i] / maxele;
            }
        }


        void mergeSortRec(int[] arr, int beg,
                          int end, int maxele)
        {
            if (beg < end)
            {
                int mid = (beg + end) / 2;
                mergeSortRec(arr, beg,
                        mid, maxele);
                mergeSortRec(arr, mid + 1,
                        end, maxele);
                merge(arr, beg, mid,
                        end, maxele);
            }
        }
        public void sortColors(int[] nums) {
            int n = nums.length;
            int maxele = Arrays.stream(nums).max().getAsInt() + 1;
            mergeSortRec(nums, 0, n - 1, maxele);
        }
}
