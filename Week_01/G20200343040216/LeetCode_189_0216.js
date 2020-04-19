/*
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */

 // 解法1; 暴力法

function rotate(nums, k) {
  
  for (let i = 0; i < k ; i++ ) {
    // 删除最后一个
    const last = nums.pop();
    // 插入到前面
    nums.unshift(last);
  }

  return nums
}

// 解法2：
