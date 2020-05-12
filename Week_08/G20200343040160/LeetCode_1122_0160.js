/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let arr = new Array(1001).fill(0);
  arr1.forEach(num => {
      ++arr[num];
  })
  let i = 0;
  arr2.forEach(num => {
      while (arr[num]--)
          arr1[i++] = num;
  })

  arr.forEach((item, index) => {
      while (item-- > 0) {
          arr1[i++] = index;
      }
  })
  return arr1;
};