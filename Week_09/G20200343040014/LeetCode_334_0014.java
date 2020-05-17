class Solution {
    public void reverseString(char[] s) {
        for (int i = 0,j = s.length -1; i < j; i++,j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}