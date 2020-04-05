/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  const len = bills.length;
  let change = {
      '5': 0,
      '10': 0,
  }
  for (let i = 0; i < len; i++) {
      if (bills[i] === 5) change['5']++;
      else if (bills[i] === 10) {
          if (!change['5']--) {
              return false;
          } else {
              change['10']++;
          }
      } else {
          if (change['10'] && change['5']) {
              change['10']--;
              change['5']--;
          } else if (change['5'] > 2) {
              change['5']-= 3;
          } else {
              return false;
          }
      }
  }
  return true;
};