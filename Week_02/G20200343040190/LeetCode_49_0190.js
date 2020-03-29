/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  var keysArray = {};
  for (var i = 0; i < strs.length; i++) {
      var sortedKey = strs[i].split('').sort().join('');
      if (!keysArray[sortedKey]) {
          keysArray[sortedKey] = [strs[i]];
      } else {
          keysArray[sortedKey].push(strs[i]);
      }
  }
  return Object.keys(keysArray).map(key => keysArray[key]);
};