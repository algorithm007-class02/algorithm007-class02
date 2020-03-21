package week02.g20200343040172;

import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode-20 有效的括号
 */
public class LeetCode_20_0172 {

    private HashMap<String, String> map;

    /**
     * 使用栈
     * 先用Map新建一个对应关系
     * 遇到左括号则放入栈，遇到右括号，匹配则出栈，把右括号作为Key，左括号作为value
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        HashMap<String, String> map = new HashMap<>(3);
        Stack stack = new Stack();
        map.put("]", "[");
        map.put(")", "(");
        map.put("}", "{");
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (s.length() < 2) {
                return false;
            }
            if (this.map.containsKey(str) && (!stack.isEmpty())) {
                if (!this.map.get(str).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(str);
            }
        }
        return (stack.isEmpty()) && (!s.equals(null)) ? true : false;
    }
}
