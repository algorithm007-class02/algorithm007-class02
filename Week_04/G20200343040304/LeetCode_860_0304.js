/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function (bills) {
  const map = {};
  for (let i = 0; i < bills.length; i++) {
    if (bills[i] === 10) {
      if (!map[5]) {
        return false;
      } else {
        map[5] -= 1;
      }
    } else if (bills[i] === 20) {
      if (map[10] && map[5]) {
        map[5] -= 1;
        map[10] -= 1;
      } else if (map[5] && map[5] >= 3) {
        map[5] -= 3;
      } else {
        return false;
      }
    }

    if (!map[bills[i]]) {
      map[bills[i]] = 1;
    } else {
      map[bills[i]] += 1;
    }
  }

  return true;
};