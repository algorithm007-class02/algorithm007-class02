/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
  const n = M.length;
  let students = new Array(n), result = n;
  for(let i = 0; i < n; i++) {
      students[i] = i;
  }
  for (let i = 0; i < n; i++) {
      for (let j = i + 1; j < n; j++) {
          if (M[i][j] === 1) {
              let [a, b] = [i, j];
              while (students[a] !== a) a = students[a]; 
              while (students[b] !== b) b = students[b];
              if (a !== b) {
                 students[a] = b;
                 --result;  
              }
          }
      }
  }
  return result;
};