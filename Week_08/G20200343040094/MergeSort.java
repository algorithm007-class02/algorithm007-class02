package SortAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private void merge(int[] array, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];
        System.arraycopy(temp, 0, array, begin, temp.length);
    }

    public static void main(String[] args) {
        MergeSort mgs = new MergeSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        mgs.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
