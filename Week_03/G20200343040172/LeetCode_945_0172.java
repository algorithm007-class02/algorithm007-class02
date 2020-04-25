package week03.g20200343040172;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * 每日一题 LeetCode-945 使数组唯一的最小增量
 */
public class LeetCode_945_0172 {
    /**
     * 超时了
     * @param A
     * @return
     */
    public int minIncrementForUnique_1(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if (set.add(temp)) {
                ;
            } else {
                while (!set.add(temp)) {
                    temp++;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 这个可以通过
     * @param A
     * @return
     */
    public int minIncrementForUnique_2(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int[] arr = new int[80000];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (arr[A[i]] == 0) {
                arr[A[i]] = 1;
            } else {
                while (arr[A[i]] != 0) {
                    A[i] += 1;
                    count++;
                }
                arr[A[i]] = 1;
            }
        }
        return count;
    }
}
