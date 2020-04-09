/**
 * 题目：柠檬水找零
 * 思路：贪心算法
 * @param {number[]} bills
 * @return {boolean}
 */

var lemonadeChange = function (bills) {
  let countFive = 0;
  let countTen = 0;

  for (let i = 0; i < bills.length; i++) {
    if (bills[i] === 5) countFive++;
    if (bills[i] === 10) {
      countFive--;
      countTen++;
    }
    if (bills[i] === 20 && countTen > 0) {
      countFive--;
      countTen--;
    } else if (bills[i] === 20) countFive -= 3;

    if (countFive < 0 || countTen < 0) return false;
  }

  return true;
};
