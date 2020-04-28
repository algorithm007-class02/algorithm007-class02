package SortAlgorithms;

import java.util.Arrays;

public class HeapSort {
    public void heapsort(int[] array) {
        int len = array.length;
        if (len == 0) return;
        for (int i = len / 2 - 1; i >= 0; --i) {
            heapify(array, len, i);
        }
        for (int i = len - 1; i >= 0; --i) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) largest = left;
        if (right < length && array[right] > array[largest]) largest = right;
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void main(String[] args) {
        HeapSort hps = new HeapSort();
        int[] a = new int[]{5, 8, 9, 1, 5, 2, 90, -3};
        hps.heapsort(a);
        System.out.println(Arrays.toString(a));
    }
}
