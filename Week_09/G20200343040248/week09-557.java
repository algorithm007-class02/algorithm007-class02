class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (left <= right && s.charAt(right) == ' ') --right;

        StringBuilder resultStr = new StringBuilder();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                word.reverse();
                resultStr.append(word);
                resultStr.append(' ');
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        word.reverse();
        resultStr.append(word);

        return resultStr.toString();
    }
}
//跟151的题一样，只不过把word反转一下再添加，不需要双端队列存储