/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var sortStr = str => {
  return  str.split('').sort().join('');
}

var groupAnagrams = function(strs) {
  var map = new Map();

  for(let i = 0 ; i < strs.length; i++) {
    var str = sortStr(strs[i]);
    if (map.has(str)) {
      var r = map.get(str);
      r.push(strs[i]);
      map.set(str, r)
    } else {
      map.set(str, [strs[i]])
    }
  }

  return Array.from(map.values());

};

/**
 * 执行结果：
通过
显示详情
执行用时 :
128 ms
, 在所有 JavaScript 提交中击败了
94.86%
的用户
内存消耗 :
44.6 MB
, 在所有 JavaScript 提交中击败了
98.46%
的用户
 */