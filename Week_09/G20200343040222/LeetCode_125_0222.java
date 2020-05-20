public class LeetCode_125_0222 {

    /**
     * 用java自带的字符串操作 时间复杂度为O(N) 空间复杂度为O(N) N为字符串长度
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString().equals(sb.reverse().toString());

    }

    /**
     * 双指针  时间复杂度为O(N) 空间复杂度为O(N) N为字符串长度
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String str = s.toLowerCase();
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

}