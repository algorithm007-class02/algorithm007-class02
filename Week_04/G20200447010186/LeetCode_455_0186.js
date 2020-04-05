/**
 * 题目：分发饼干
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 * 思路：贪心算法
 */

/**
 * 贪心思路：将孩子胃口和饼干大小升序排列，每次从头开始比较两个指针，优先用小的饼干满足胃口，如果不行再找下一块大饼干
 * 复杂度：O(n)
 */
var findContentChildren = function (g, s) {
  // 首先肯定要将两个数组都变为升序集合
  g = g.sort((a, b) => a - b);
  s = s.sort((a, b) => a - b);

  let i = 0; //定义2指针
  let j = 0; //定义2指针
  let count = 0; //定义最终结果

  while (i < g.length && j < s.length) {
    // 当孩子胃口小于等于饼干，能被满足时
    if (g[i] <= s[j]) {
      count += 1;
      i++;
      j++;
    } else {
      j++;
    }
  }
  return count;
};
