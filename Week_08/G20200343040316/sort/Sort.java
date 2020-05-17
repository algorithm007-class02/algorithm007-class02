package com.wxs.algorithm1.week08.sort;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Sort {


    public static void main(String[] args) {
        int[] arr = {4,2,5,8,1,16,23,12};
        Sort sort = new Sort();
        //sort.bubbleSort(arr);
        //sort.selectionSort(arr);
        //sort.insertionSort(arr);

        sort.quickSort(arr,0,arr.length - 1);
        System.out.println(arr);



    }

    /**
     * 冒泡就是比较相邻的数，两次嵌套循环， 用第二次循环的变量比较（如： arr[j-1）> arr[j],注意：控制好边界
     * 每次循环都能找到最大值，最大值放在数组的最后位置(随着循环进行，最后位置 arr.length - i - 1)
     *
     * @param arr
     */
   public void bubbleSort(int[] arr){

       for (int i = 0; i < arr.length; i++) {
           for (int j = 1; j < arr.length -i; j++) {

               if(arr[j-1] > arr[j]){
                   swap(arr,j-1,j);
               }

           }

       }

   }

    private void swap(int[] arr, int i, int j) {

       if(i == j){
           return;
       }
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

    /**
     * 选择排序正好和冒泡相反，最小值放在最前面，最外层循环i的最大位置为 length-2（ i < lengh-1）
     * @param arr
     */
    public void selectionSort(int[] arr){


        for (int i = 0; i < arr.length - 1; i++) {
            // 记录一次循环后的最小值，后续用来替换
            int mixIndex = i;

            for (int j = i+1; j < arr.length; j++) {
               if(arr[i] > arr[j]){
                   mixIndex = j;
               }

            }
            swap(arr,i,mixIndex);
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public void insertionSort(int[] arr){

        int preIndex,currIndexValue;

        for (int i = 1; i < arr.length; i++) {


            preIndex = i -1;

            currIndexValue = arr[i];

            while (preIndex >=0 && arr[preIndex] > currIndexValue){
                arr[preIndex +1] = arr[preIndex];
                preIndex--;
            }

            arr[preIndex+1] = currIndexValue;

        }

    }




    public void megerSrot(int[] arr , int left, int right){

        if(left >= right){
            return;
        }
        int mid = (left + right) >> 1;


        megerSrot(arr,left,mid);
        megerSrot(arr, mid+1,right);
        // 合并两个有序的数组
        meger(arr,left,mid,right);
    }

    private void meger(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left,j = mid+1, k = 0;

        while (i <= mid && j <= right){
            temp[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }


        while (i <= mid)temp[k++] = arr[i++];
        while (j<=right)temp[k++] = arr[j++];


        for (int l = 0; l < temp.length; l++) {

            arr[l+left] = temp[l];

        }

    }

    public void quickSort(int[] arr,int begin,int end){
        if(end <= begin){
            return;
        }

       int para =  paratition1(arr,begin,end);

        quickSort(arr,begin,para-1);
        quickSort(arr,para+1,end);

    }



    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end;
        int counter = begin;

        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }


    private int paratition1(int[] arr,int begin,int end){

        int pivot = end;
        int counter = begin;

        for (int i = begin; i < end; i++) {
           if(arr[i] < arr[pivot]){
               swap(arr,i,counter);
               counter++;
           }
        }

        swap(arr,counter,pivot);

        return counter;

    }


}
