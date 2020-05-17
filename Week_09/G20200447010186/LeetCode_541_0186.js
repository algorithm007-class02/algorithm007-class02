/**
 * 翻转字符串：
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转
 */
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */

// substr(start,length) : substr(开始截取的位置,一共截取的字符数)
// substring(startIndex,indexEnd): 停止截取的位置，以该数字为索引的字符不包含在截取的字符串内
// substr方法现已经不推荐使用，应该用substring方法代替它

var reverseStr = function (s, k) {
  if (!s.length) return "";

  // 首先根据2k的长度对字符串进行划分。一个数组里的多个元素，每个元素长度为2k
  const splitArr = [];
  const itemLength = 2 * k;
  // 算出根据2k来划分，划分成的数组长度是多少
  const len = s.length / itemLength;
  for (let i = 0; i < len; i++) {
    const items = s.substring(i * itemLength, i * itemLength + itemLength);

    splitArr.push(items); // push每次2k个字符 0 2k
  }

  // 对前 k 个字符进行反转
  const last = splitArr.map((item) => {
    const needReverseStr = item.substring(0, k).split("").reverse().join("");
    const otherStr = item.substring(k, item.length);
    return needReverseStr + otherStr;
  });

  return last.join("");
};
