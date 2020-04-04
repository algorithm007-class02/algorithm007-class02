/**
 * 题目：字母异位词分组
 * @param {string[]} strs
 * @return {string[][]}
 */

/**
 * 解法1：仅维护一个hash表，其中的键值为排序后的字符串.
 * 遍历给定字符串数组时，将当前值先排序之后，再去哈希表里查找.
 * 1 未查找到，则往hash表中塞入新排序字符串，值为一个数组，内放排序前的当前值.
 * 2 查找到，往对应的hash表的映射键中再加入当前排序前的当前值.
 *
 * 最后取得该hash表的值即可.利用Object.values()
 * Object.values()返回给定对象自己的可枚举属性值的数组
 */
var groupAnagrams = function(strs) {
  const hash = new Map();
  for (let i = 0; i < strs.length; i++) {
    const sortStr = strs[i]
      .split("")
      .sort()
      .join("");
    if (hash.has(sortStr)) {
      const value = hash.get(sortStr);
      value.push(strs[i]);
      hash.set(sortStr, value);
    } else {
      hash.set(sortStr, [strs[i]]);
    }
  }
  // 取map中数据：values()
  return [...hash.values()];
};

/**
 * 解法2:
 *  解法1的new Map()换成obj
 *  for循环的基础写法换成for ..of: for(const item of obj){}
 * 但是耗时比解法1长
 */
var groupAnagrams = function(strs) {
  const hash = {};
  for (const item of obj) {
    const sorted = item
      .split("")
      .sort()
      .join("");
    if (!hash[sorted]) {
      hash[sorted] = item;
    } else {
      hash[sorted].push(item);
    }
  }
  return Object.values(hash);
};
