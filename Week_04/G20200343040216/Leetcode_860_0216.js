/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  var five = 0, ten = 0, twenty = 0;

  for (var i = 0 ; i < bills.length; i++) {
      
      if(bills[i] === 5) {
          five++
      } else if (bills[i] === 10) {
          if(five == 0) return false
          ten++
          five--;
      } else {
          if(five > 0 && ten > 0) {
              five--
              ten--
          } else if (five >= 3 && ten == 0) {
              five-= 3;
          }else {
              return false
          }
      }
  }

  if(five < 0  || ten < 0) return false

  return true

};