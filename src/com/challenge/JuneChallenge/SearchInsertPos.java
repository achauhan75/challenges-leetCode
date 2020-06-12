package com.challenge.JuneChallenge;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 */
public class SearchInsertPos {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int low = 0;
        int high = n-1;
        int mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high + 1;
    }
    // Driver code
    static public void main (String[] args)
    {
        int []arr = {1,3,5,6};
        int n = 0;
        System.out.println(searchInsert(arr, n));
    }
}
