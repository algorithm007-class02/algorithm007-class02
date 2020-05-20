class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chArr = S.toCharArray();
        int len = chArr.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (!Character.isLetter(chArr[left])) {
                left++;
            } else if (!Character.isLetter(chArr[right])) {
                right--;
            } else {
                swap(chArr, left++, right--);
            }
        }
        return new String(chArr);
    }

    private void swap(char[] chArr, int fisrt, int second) {
        char temp = chArr[fisrt];
        chArr[fisrt] = chArr[second];
        chArr[second] = temp;
    }
}