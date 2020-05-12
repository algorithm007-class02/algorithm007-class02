package SortAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public void insertionSort(int[] array) {
        int len = array.length;
        int preIndex, cur;
        for (int i = 1; i < len; ++i) {
            preIndex = i - 1;
            cur = array[i];
            while (preIndex >= 0 && cur < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = cur;
        }
    }

    public static void main(String[] args) {
        InsertionSort iss = new InsertionSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        iss.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
