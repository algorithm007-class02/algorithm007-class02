import java.util.Stack;

class Solution {
    //字母栈，先入后出
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(letters.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //反转指针，从前向后遍历，如果碰到字母，则反转，从后向前添加第一个字母；如果不为字母则进行添加
    public String reverseOnlyLetters1(String S) {
        StringBuilder sb = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                sb.append(S.charAt(j--));
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}