class Solution {
    public void rotate(int[] nums, int k) {

        if (nums == null || k < 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int curr, last;

        //solv1: rotate k times:
        //time: O(k * n)
        //space: O(1)
        // for (int i=0; i<k; i++) {
        //     last = nums[n-1];
        //     for (int j=0; j<n; j++) {
        //         curr = nums[j];
        //         nums[j] = last;
        //         last = curr;
        //     }   
        // }

        //solv2: array clone
        //time: O(n)
        //space: O(n)
        // int[] arrayCopy = nums.clone();
        // for (int i=0; i<n; i++) {
        //     nums[i] = arrayCopy[(n-k+i) % n];
        // }

        //solv3: 3 times reverse
        //time:  O(n)
        //space: O(1)
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }   


    public void reverse(int[] arr, int start, int end) {
        int halfLen = (end - start + 1) / 2;
        int fst, lst;

        for (int i=0; i<halfLen; i++) {
            lst = arr[end-i];
            fst = arr[start+i];

            arr[start+i] = lst;
            arr[end-i] = fst;
        }
    }
}