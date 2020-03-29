/*
 * @Author: mingxing.huang
 * @Date: 2020-03-20 14:57:40
 */
/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
   输出:
    [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
    ]
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  // 暴力法思路：遍历strs，找出当前单词的每一个异位词，归为一组。（不能ac）
  // 散列表思路：异位词的特点是排序后是相同的字符串，可以将排序后的字符串进行比较，如果相同，它们就是异位词
  let hashMap = {};
  for (const word of strs) {
    // 将单词排序就行比较
    const sortedW = word
      .split("")
      .sort()
      .join("");
    if (hashMap[sortedW] !== undefined) {
      hashMap[sortedW].push(word);
    } else {
      hashMap[sortedW] = [word];
    }
  }
  return Object.values(hashMap);
};
