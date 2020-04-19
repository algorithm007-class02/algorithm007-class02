//  for循环map保存Anagrams的key和result

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  let hash = new Map()

  for (let i = 0; i < strs.length; i++) {
    let str = strs[i].split('').sort().join()
    if (hash.has(str)) {
      let temp = hash.get(str)
      temp.push(strs[i])
      hash.set(str, temp)
    } else {
      hash.set(str, [strs[i]])
    }
  }

  return [...hash.values()]
};



//  双指针，收集结果集并且返回。时间复杂度偏高。

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
function isAns(str1, str2) {
  if (str1.length !== str2.length) {
    return false;
  }
  const map = {};
  for (let i = 0; i < str1.length; i++) {
    const s = str1[i];
    if (map[s]) {
      map[s] += 1;
    } else {
      map[s] = 1;
    }
  }
  for (let i = 0; i < str2.length; i++) {
    if (map[str2[i]]) {
      map[str2[i]] -= 1;
    } else {
      return false;
    }
  }
  return true;
}

var groupAnagrams = function (strs) {
  let result = [];
  let cache = {};
  for (let i = 0; i < strs.length; i++) {
    if (cache[i]) {
      continue;
    }
    const arr = [strs[i]];
    for (let j = i + 1; j < strs.length; j++) {
      if (cache[j]) {
        continue;
      }
      const isAnsStatus = isAns(strs[i], strs[j]);
      if (isAnsStatus) {
        arr.push(strs[j])
        cache[j] = true;
      }
    }
    result.push(arr);
  }
  return result
};