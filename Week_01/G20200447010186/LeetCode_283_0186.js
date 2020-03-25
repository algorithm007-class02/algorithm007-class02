/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */

var moveZeroes = function(arr) {
  let j = 0; // 用于存放非0元素的位置
  for (let i = 0, len = arr.length; i < len; i++) {
    if (arr[i] !== 0) {
      arr[j] = arr[i];
      if (j !== i) {
        arr[i] = 0; // 将原来位置赋0
      }
      j++; // 当j被放置之后往后挪动1位
    }
  }
};
