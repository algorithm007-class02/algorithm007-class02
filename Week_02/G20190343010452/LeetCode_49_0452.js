/**
 * @param {string[]} strs
 * @return {string[][]}
 */

// 使用排序 O(nlogn)
var groupAnagrams1 = function (strs) {
  let hashMap = new Map()

  for (let i = 0; i < strs.length; i++) {
    let str = strs[i].split('').sort().join()
    if (hashMap.has(str)) {
      let temp = hashMap.get(str)
      temp.push(strs[i])
      hashMap.set(str, temp)
    } else {
      hashMap.set(str, [strs[i]])
    }
  }

  return [...hashMap.values()];

};

// O(n)
var groupAnagrams2 = function (strs) {
  let result = {};

  for (let i = 0; i < strs.length; i++) {
    const str = strs[i];
    const hash = str.split('').reduce((sum, s) => {
      return sum * [3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103][s.charCodeAt(0) - 97];
    }, 1);

    result[hash] ? result[hash].push(str) : result[hash] = [str];
  }

  return Object.values(result);
}


// 思路都在于如何设计唯一键