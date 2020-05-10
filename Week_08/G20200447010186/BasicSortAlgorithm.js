/**
 * 初级排序实现 复杂度均为O(n2)
 * 选择排序、插入排序、冒泡排序
 */

/**
 * 1、选择排序
 * 将元素分为已排序区间和未排序区间，初始默认第一个元素为已排序区间。
 * 每次从未排序区间中选择最小值放在已排序区间的末尾。（具体放法：若最小值比末尾值小，交换二者）
 */
function selectionSort(arr) {
  const len = arr.length;
  let temp;
  if (!len) return;
  for (let i = 0; i < len - 1; i++) {
    let minIndex = i;
    // 在i之后的区间寻找比i下标处小且最小的元素，进行二者交换
    for (let j = i + 1; j < len; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j; // 在之后的区间中比较时不断更新最小值下标
      }
    }
    // 此时minIndex为每次i之后区间里面最小值下标。接下来将其最小值和i位置的元素交换
    temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
  }
  return arr;
}

/**
 * 2、插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描。找到相应位置插入
 */
function insertionSort(arr) {
  const len = arr.length;
  if (!len) return;
  var current, sortLastIndex;

  for (let i = 1; i < len; i++) {
    current = arr[i]; // 定义新元素
    sortLastIndex = i - 1; // 已排序区间区间的最后一个位置

    // 如果arr[sortLastIndex]大于新元素，将该元素arr[sortLastIndex]移到下一位置
    while (sortLastIndex >= 0 && arr[sortLastIndex] > current) {
      arr[sortLastIndex + 1] = arr[sortLastIndex];
      sortLastIndex--;
    }
    // 直到sortLastIndex代表的值小于新元素，这时候将新元素放置在它之后。
    arr[sortLastIndex + 1] = current;
  }

  return arr;
}

/**
 * 3、冒泡排序
 */
function bubbleSort(arr) {
  const len = arr.length;
  if (!len) return;

  for (let i = 0; i < len - 1; i++) {
    for (let j = 0; j < len - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  return arr;
}

/**
 * 计数排序
 */
function countingSort(arr) {
  // 找到最大值max
  const max = Math.max(...arr);
  // 开辟计数数组，长度为max + 1
  const countingArr = new Array(max);

  for (let i = 0; i < arr.length; i++) {
    const current = arr[i];
    if (!countingArr[current]) {
      countingArr[current] = 1;
    } else {
      countingArr[current] += 1;
    }
  }
  console.log(countingArr);
  const result = [];
  for (let i = 0; i < countingArr.length; i++) {
    if (!countingArr[i]) continue;
    while (countingArr[i] > 0) {
      // 根据下标对应的值将下标写入新数组
      result.push(i);
      countingArr[i]--;
    }
  }
  console.log(result);
  return result;
}
