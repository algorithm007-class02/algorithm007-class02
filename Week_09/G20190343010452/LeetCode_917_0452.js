var isLetter = function(c) {
  return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
}

var swap = function(array, a, b) {
  let t = array[a];
  array[a] = array[b];
  array[b] = t;
}

var reverseOnlyLetters = function(S) {
  var result = S.split('');
  let l = 0;
  let r = result.length - 1;

  while (l < r) {
      if (!isLetter(result[l].charCodeAt())) {
          l++;
      } else if (!isLetter(result[r].charCodeAt())) {
          r--;
      } else {
          swap(result, l++, r--);
      }
  }

  return result.join('');
};