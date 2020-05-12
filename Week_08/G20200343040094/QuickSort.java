package SortAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; ++i) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        qs.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
