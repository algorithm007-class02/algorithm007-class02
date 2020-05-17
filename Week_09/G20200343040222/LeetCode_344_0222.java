public class LeetCode_344_0222 {

    /**
     * 普通解法 时间复杂度 O(N) 空间复杂度O(1) N s长度
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }

    /**
     * 递归 时间复杂度 O(N) 空间复杂度O(1) N s长度
     * @param s
     */
    public void reverseStringRe(char[] s) {
        recure(s, 0, s.length - 1);
    }

    private void recure(char[] s, int left ,int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        recure(s, left + 1, right - 1);
    }
}