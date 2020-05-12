```java
private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
}   
```

 >选择排序：每一轮选择最小元素交换到未排定部分的开头

 ```java
public int[] sortArray(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < len; j++) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        swap(nums, i, minIndex);
    }
    return nums;
}
```
> 插入排序：稳定排序，在接近有序的情况下，表现优异

```java
public int[] sortArray(int[] nums) {
    int len = nums.length;
    // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
    for (int i = 1; i < len; i++) {
        // 先暂存这个元素，然后之前元素逐个后移，留出空位
        int temp = nums[i];
        int j = i;
        // 注意边界 j > 0
        while (j > 0 && nums[j - 1] > temp) {
            nums[j] = nums[j - 1];
            j--;
        }
        nums[j] = temp;
    }
    return nums;
}
```

>  // 冒泡排序

```java
public int[] sortArray(int[] nums) {
    int len = nums.length;
    for (int i = len - 1; i >= 0; i--) {
        // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
        // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
        boolean sorted = true;
        for (int j = 0; j < i; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1);
                sorted = false;
            }
        }
        if (sorted) {
            break;
        }
    }
    return nums;
}
```

> 计数排序

```java
private static final int OFFSET = 50000;
public int[] sortArray(int[] nums) {
    int len = nums.length;
    // 由于 -50000 <= A[i] <= 50000
    // 因此"桶" 的大小为 50000 - (-50000) = 10_0000
    // 并且设置偏移 OFFSET = 50000，目的是让每一个数都能够大于等于 0
    // 这样就可以作为 count 数组的下标，查询这个数的计数
    int size = 10_0000;
    // 计数数组
    int[] count = new int[size];
    // 计算计数数组
    for (int num : nums) {
        count[num + OFFSET]++;
    }
    // 把 count 数组变成前缀和数组
    for (int i = 1; i < size; i++) {
        count[i] += count[i - 1];
    }
    // 先把原始数组赋值到一个临时数组里，然后回写数据
    int[] temp = new int[len];
    System.arraycopy(nums, 0, temp, 0, len);

    // 为了保证稳定性，从后向前赋值
    for (int i = len - 1; i >= 0; i--) {
        int index = count[temp[i] + OFFSET] - 1;
        nums[index] = temp[i];
        count[temp[i] + OFFSET]--;
    }
    return nums;
}
```

> 归并排序

```java
private void mergeSort(int[] nums, int left, int right) {  // 需要左右边界确定排序范围
    if (left >= right) return;
    int mid = (left+right) / 2;

    mergeSort(nums, left, mid);                           // 先对左右子数组进行排序
    mergeSort(nums, mid+1, right);

    int[] temp = new int[right-left+1];                   // 临时数组存放合并结果
    int i=left,j=mid+1;
    int cur = 0;
    while (i<=mid&&j<=right) {                            // 开始合并数组
        if (nums[i]<=nums[j]) temp[cur] = nums[i++];
        else temp[cur] = nums[j++];
        cur++;
    }
    while (i<=mid) temp[cur++] = nums[i++];
    while (j<=right) temp[cur++] = nums[j++];

    for (int k = 0; k < temp.length; k++) {             // 合并数组完成，拷贝到原来的数组中
        nums[left+k] = temp[k];
    }
}
```

>  快速排序

```java
private void quickSort(int[] nums, int left, int right) {
    if (left>=right) return;
    int cur = left + 1;                   // 从左侧第二个元素开始
    int lo = left;                        // 分界点为第一个元素
    while (cur <= right) {
        if (nums[cur] <= nums[left]) {    // 交换位置保证lo的左侧都是小于num[left]
            swap(nums, lo+1, cur);
            lo ++;
        }
        cur++;
    }
    swap(nums, left, lo);                 // 把分界点元素移动到新的分界位置
    quickSort(nums, left, lo-1);
    quickSort(nums, lo+1, right);
}
```
