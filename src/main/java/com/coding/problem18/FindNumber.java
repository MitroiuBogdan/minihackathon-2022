package com.coding.problem18;

import java.util.Arrays;

/**
 * You are given a sorted array. Find a special number
 * in the array that appears more than a 25% of the time.
 * If found return that integer, otherwise return -1;
 * <p>
 * Example 1:
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * <p>
 * Example 2:
 * Input: arr = [1,1]
 * Output: 1
 */
public class FindNumber {

    public int findSpecialNumber(int[] arr) {
        int quarter = arr.length / 4;
        for (int i = 0; i < arr.length - quarter; i++) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }
        return -1;
    }
}
