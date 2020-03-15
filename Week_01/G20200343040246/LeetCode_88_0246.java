package Week_01.G20200343040246;

import java.util.*;

public class LeetCode_88_0246 {
    public static void main(String[] args) {
        
    }

    public class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 1: double point, from last to first merge; O(m+n)
            int i = m - 1, j = n - 1, k = m + n - 1;
            while(i >= 0 && j >= 0) {
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
            while(j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
        
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            // 2: merge than sort array; O((m+n)log(m+n))
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }

        public void merge3(int[] nums1, int m, int[] nums2, int n) {
            // 3: doublie point, from first to last merge; O(m+n)
            int [] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);

            int p1 = 0;
            int p2 = 0;

            int p = 0;

            while ((p1 < m) && (p2 < n))
                nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

            if (p1 < m)
                System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            if (p2 < n)
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

    }
}