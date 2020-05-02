class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length], arr = new int[1001];
        int index = 0;
        for (int arr1Item : arr1) {
            ++arr[arr1Item];
        }

        for (int arr2Item : arr2) {
            while (arr[arr2Item]-- > 0) {
                res[index] = arr2Item;
                ++index;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while(arr[i]-- > 0) {
                res[index] = i;
                ++index;
            }
        }

        return res;
    }
}