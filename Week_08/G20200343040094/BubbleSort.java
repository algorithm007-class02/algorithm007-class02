package SortAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - 1 - i; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bbs = new BubbleSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        bbs.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
