class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (left <= right && s.charAt(right) == ' ') --right;

        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
//用双端队列实现，首先去除头尾的空格，创建双端队列和一个临时字符串
//当串不为空并且碰到空格，说明一个完整字符完成，添加到队列头部，并置空字符串。
//否则继续添加字符到字符串，left++,最后一个字符串由于没有空格没有加入双端队列
//最后循环完毕，把最后一个字符串加入双端队列，再变成字符串。