class Solution {

  public int[] plusOne(int[] digits) {
    int i = 1;
    if (digits.length == 1 && digits[0] == 9) {
      int[] arr = {1, 0};
      return arr;
    }
    while (i <= digits.length) {
      if (digits[digits.length - i] + 1 == 10) {
        digits[digits.length - i] = 0;
        i++;
      } else {
        digits[digits.length - i] = digits[digits.length - i] + 1;
        break;
      }
      if (digits[0] == 0) {
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
      }
    }
    return digits;
  }
}