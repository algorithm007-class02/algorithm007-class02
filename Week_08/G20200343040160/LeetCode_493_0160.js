/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
  let count = 0;
  function heapSort(list, left, right) {
      if (left >= right) return;
      const mid = left + ((right - left) >> 1);
      heapSort(list, left, mid);
      heapSort(list, mid+ 1, right);
      let j = mid + 1;
      for (let i = left; i <= mid; i++) {
          while (j <= right && list[i] > list[j] * 2)
              j++;
          count += j - mid - 1;
      }
      merge(list, left, mid, right);
  }

  function merge(list, left, mid, right) {
      let arr1 = list.slice(left, mid + 1), arr2 = list.slice(mid + 1, right + 1);
      let i = 0, k = 0;
      while (arr1.length && arr2.length) {
          list[left + i++] = arr1[0] < arr2[0] ? arr1.shift() : arr2.shift();
      }
      while (arr1.length) {
          list[left + i++] = arr1.shift();
      }
      while (arr2.length) {
          list[left + i++] = arr2.shift();
      }
  }

  heapSort(nums, 0, nums.length - 1);

  return count;
};