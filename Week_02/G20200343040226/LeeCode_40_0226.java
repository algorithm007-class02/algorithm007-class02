package com.logic;

import java.util.Arrays;

/**
 * @Auther: welllu
 * @Date: 2020/3/20 22:53
 * @Description:
 */
public class LeeCode_40_0226 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int low, int hi, int k) {
        int j = partion(arr, low, hi);
        if(j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j > k ? quickSearch(arr, low, j - 1, k) : quickSearch(arr, j + 1, hi, k);
    }

    private int partion(int[] arr, int low, int hi) {
        int v = arr[low];
        int i = low;
        int j = hi + 1;
        while(true) {
            while(++i <= hi && arr[i] < v);
            while(--j >= low && arr[j] > v);
            if(i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[low] = arr[j];
        arr[j] = v;
        return j;
    }
}
