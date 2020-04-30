package SortAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public void selectionSort(int[] array) {
        int len = array.length;
        int minIndex = 0;
        for (int i = 0; i < len; ++i) {
            minIndex = i;
            for (int j = i; j < len; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sls = new SelectionSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        sls.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
