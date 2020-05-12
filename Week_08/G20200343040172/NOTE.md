## N皇后位运算解决
N皇后的位运算花了很久的时间才明白，特将此记录如下：
[位运算解决N皇后 详细图解](https://blog.csdn.net/qq_42799615/article/details/105876141)
## 冒泡排序（Bubble Sort）
> 使用两层for循环，只要发现a[i] > a[i+1]则交换两元素的位置
```java
 // 冒泡排序，a是数组，n表示数组大小
  public void bubbleSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n; ++i) {
      // 提前退出标志位
      boolean flag = false;
      for (int j = 0; j < n - i - 1; ++j) {
        // 交换
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          // 此次冒泡有数据交换
          flag = true;
        }
      }
      // 没有数据交换，提前退出
      if (!flag) {
        break;
      }
    }
  }
```
## 选择排序（Selection Sort）
> 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。 
```java
 // 选择排序，a表示数组，n表示数组大小
  public void selectionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n - 1; ++i) {
      // 查找最小值
      int minIndex = i;
      for (int j = i + 1; j < n; ++j) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }

      // 交换
      int tmp = a[i];
      a[i] = a[minIndex];
      a[minIndex] = tmp;
    }
  }
```
## 插入排序（Insertion Sort）
> 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
```java
// 插入排序，a表示数组，n表示数组大小
  public void insertionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }
    for (int i = 1; i < n; ++i) {
      int value = a[i];
      int j = i - 1;
      // 查找要插入的位置并移动数据
      for (; j >= 0; --j) {
        //遍历已排序区间的元素，若已排序区间的元素a[j] > value
        if (a[j] > value) {
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      a[j + 1] = value;
    }
  }
```
## 希尔排序（Shell Sort）
> 插入排序的升级版，选择一个步长，每次遍历不是依次遍历，而是根据步长进行遍历
```java
public void shellSort(int[] arr) {
    int len = arr.length;
    if (len == 1) {
      return;
    }

    int step = len / 2;
    while (step >= 1) {
      for (int i = step; i < len; i++) {
        int value = arr[i];
        int j = i - step;
        for (; j >= 0; j -= step) {
          if (value < arr[j]) {
            arr[j + step] = arr[j];
          } else {
            break;
          }
        }
        arr[j + step] = value;
      }
      step = step / 2;
    }
  }
```
## 归并排序（Merge Sort）
> 先把长度为n的输入序列分成两个长度为n/2的子序列，再对这两个子序列分别采用归并排序，再将两个排序好的子序列合并成一个最终的排序序列。
```java
public static void main(String[] args) {
    int[] array = new int[]{3, 5, 1, 2, 4, 8, 0};
    // 调用归并排序
    mergeSort(array, 0, array.length - 1);
    for (int arr : array) {
      System.out.println(arr);
    }
  }

  public static void mergeSort(int[] arr, int left, int right) {
    if (right <= left) {
      return;
    }
    // (left + right) >> 1等效为(left + right) / 2
    int mid = (left + right) >> 1;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    // 取出左半边和右半边中的较小值放入tmp数组
    while (i <= mid && j <= right) {
      tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }
    // 若i <= mid，则说明左半边的数据没有放完，再依次放入tmp即可
    while (i <= mid) {
      tmp[k++] = arr[i++];
    }
    // 若j <= right，则说明右半边的数据没有放完，再依次放入tmp即可
    while (j <= right) {
      tmp[k++] = arr[j++];
    }
    // 将合并后的数组再拷贝回原数组
    for (int p = 0; p < tmp.length; p++) {
      arr[left + p] = tmp[p];
    }
    // 也可以写作：System.arraycopy(tmp, 0, arr, left, tmp.length);
    /**
     * src      the source array.
     * srcPos   starting position in the source array.
     * dest     the destination array.
     * destPos  starting position in the destination data.
     * length   the number of array elements to be copied.
     */
  }
```
## 快速排序（Quick Sort）
> 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
```java
public static void main(String[] args) {
    int[] array = new int[]{3, 5, 1, 2, 4, 8, 0};
    // 调用快排
    quickSort(array, 0, array.length - 1);
    for (int arr : array) {
      System.out.println(arr);
    }
  }

  /**
   *
   * @param arr 待排序的数组
   * @param begin 排序的起点
   * @param end 排序的终点
   */
  public static void quickSort(int[] arr, int begin, int end) {
    if (end <= begin) {
      return;
    }
    int pivot = pattition(arr, begin, end);
    quickSort(arr, begin, pivot - 1);
    quickSort(arr, pivot + 1, end);
  }

  private static int pattition(int[] arr, int begin, int end) {
    int pivot = end, counter = begin;
    for (int i = begin; i < end; ++i) {
      if (arr[i] < arr[pivot]) {
        // 使用位运算交换两个数的值
        int tmp = arr[counter] ^ arr[i];
        arr[counter] = arr[counter] ^ tmp;
        arr[i] = arr[i] ^ tmp;
        // counter统计的是在pivot左边，小于array[pivot]的元素的个数
        counter++;
      }
    }
    // 使用位运算交换两个数的值
    int tmp = arr[pivot] ^ arr[counter];
    arr[pivot] = arr[pivot] ^ tmp;
    arr[counter] = arr[counter] ^ tmp;
    return counter;
  }
```
## 堆排序（Heap Sort）
使用Java自带的函数
Java默认的是小顶堆
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
```
要实现大顶堆需要重写Compare函数
```java
 PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
```
## 计数排序（Counting Sort）
> 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
```java
 // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
  public static void countingSort(int[] a, int n) {
    if (n <= 1) return;

    // 查找数组中数据的范围
    int max = a[0];
    for (int i = 1; i < n; ++i) {
      if (max < a[i]) {
        max = a[i];
      }
    }

    // 申请一个计数数组c，下标大小[0,max]
    int[] c = new int[max + 1];

    // 计算每个元素的个数，放入c中
    for (int i = 0; i < n; ++i) {
      c[a[i]]++;
    }

    // 依次累加
    for (int i = 1; i < max + 1; ++i) {
      c[i] = c[i-1] + c[i];
    }

    // 临时数组r，存储排序之后的结果
    int[] r = new int[n];
    // 计算排序的关键步骤了，有点难理解
    for (int i = n - 1; i >= 0; --i) {
      int index = c[a[i]]-1;
      r[index] = a[i];
      c[a[i]]--;
    }

    // 将结果拷贝会a数组
    for (int i = 0; i < n; ++i) {
      a[i] = r[i];
    }
  }
```
## 桶排序（Bucket Sort）
> 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）
```java
 /**
     * 桶排序
     *
     * @param arr 数组
     * @param bucketSize 桶容量
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }

        // 数组最小值
        int minValue = arr[0];
        // 数组最大值
        int maxValue = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // 桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 数组扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }
```
## 基数排序（Radix Sort）
> 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
```java
  /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 计数排序-对数组按照"某个位数"进行排序
     *
     * @param arr
     * @param exp 指数
     */
    public static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }
```
**代码参考自：数据结构与算法之美**