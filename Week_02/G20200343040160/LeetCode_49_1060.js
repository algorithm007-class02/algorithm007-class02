/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let table = {}, ans = [];
    strs.forEach(item => {
      const len = item.length;
      let key = "abcdefghijklmnopqrstuvwxyz";
      for (let i = 0; i < len; i++) {
        key = key.replace(item[i], item[i] + "*");
      }
      table.hasOwnProperty(key) ? table[key].push(item) : table[key] = [item];
    })
    for (let item in table) {
      ans.push(table[item])
    }
    return ans;
  };