//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 示例 1:
//
//
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_557_0206 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        s = String.valueOf(chars);
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0 ; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
