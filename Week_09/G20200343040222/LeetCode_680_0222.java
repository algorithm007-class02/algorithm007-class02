public class LeetCode_680_0222 {

    /**
     * 双指针 时间复杂度 O(N) 空间复杂度O(N) N 为字符长度
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return isPalindrome(chars, i ,j - 1) || isPalindrome(chars, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}