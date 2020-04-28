/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
  let [front, last, used] = [[start], [end], []], step = 0;
  const len = start.length,
      dic = {
          'A': ['C', 'G', 'T'],
          'C': ['A', 'G', 'T'],
          'G': ['C', 'A', 'T'],
          'T': ['C', 'G', 'A']
      };
  while (front.length && last.length) {
      let temp = [];
      for (let i = 0; i < front.length; i++) {
          for (let j = 0; j < len; j++) {
              const char = front[i][j];
              for (let k = 0; k < 3; k++) {
                  const changed = front[i].slice(0, j) + dic[char][k] + front[i].slice(j+1);
                  if (!used.includes(changed) && bank.includes(changed)) {
                      if (last.includes(changed)) {
                          return step + 1; 
                      } else {
                          temp.push(changed);
                      }
                  }
              }
          }
      }
      used = used.concat(front);
      front = temp;
      if (last.length < front.length) [front, last] = [last, front];
      ++step;
  }
  return -1;
};