/**
 * 暴力解法
 * 时间复杂度O(n*k)
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
  let n = nums.length;
  if (n == 0) return [];
  let res = [];
  for (let i = 0; i < n - k + 1; i++) {
    let max = Number.MIN_SAFE_INTEGER;
    for (let j = i; j < i + k; j++) {
      max = Math.max(max, nums[j]);
    }
    res.push(max);
  }
  return res;
};

/**
 * 有序双端队列
 * 时间复杂度O(n)
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
  if (nums.length == 0) return [];
  let res = [];
  let window = new SlidingWidow();
  for (let i = 0; i < k - 1; i++) {
    window.push(nums[i]);
  }
  for (let i = k - 1; i < nums.length; i++) {
    //向前滑动
    window.push(nums[i]);
    res.push(window.max());
    window.pop(nums[i - k + 1]);
  }
  return res;
};

function SlidingWidow() {
  this.data = [];
}

SlidingWidow.prototype.max = function() {
  return this.data[0];
};

SlidingWidow.prototype.push = function(val) {
  while (this.data.length && this.data[this.data.length - 1] < val) {
    this.data.pop();
  }
  this.data.push(val);
};

SlidingWidow.prototype.pop = function(val) {
  if (this.data[0] === val) this.data.shift();
};
