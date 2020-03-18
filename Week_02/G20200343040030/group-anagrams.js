/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  let map = new Map();
  let res = [];
  for (let i = 0; i < strs.length; i++) {
    //遍历字符串
    let str = strs[i]
      .split("")
      .sort()
      .join();
    if (map.get(str) == undefined) {
      let array = [strs[i]];
      //结果集和哈希表拥有相同的数组引用，最后省去一步哈希表遍历的时间
      res.push(array);
      map.set(str, array);
    } else {
      map.get(str).push(strs[i]);
    }
  }
  return res;
};
