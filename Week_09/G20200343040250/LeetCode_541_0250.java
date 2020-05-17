class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chArr = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = i + k - 1 < len ? i + k - 1 : len - 1;

            while (left < right) {
                swap(chArr, left++, right--);
            }
        }
         return new String(chArr);
    }

     private void swap(char[] chArr, int first, int second) {
            char temp = chArr[first];
            chArr[first] = chArr[second];
            chArr[second] = temp;
        }
}