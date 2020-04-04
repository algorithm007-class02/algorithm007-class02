package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution22 {
    public static void main(String[] args) {
        // 自顶向下的编程方法
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(new char[n * 2], 0, res);
        return res;
    }

    public static void generate(char[] braces, int pos, List<String> res) {
        if (pos == braces.length) {
            if (isValid(braces))
                res.add(new String(braces));
        } else {
            // 同一位置了能出现 '(' 或 '）'
            // 重点是这里 括号一个一个放入数组中
            braces[pos] = '(';
            generate(braces, pos + 1, res);
            braces[pos] = ')';
            // 同一位置了能出现 '(' 或 '）'
            generate(braces, pos + 1, res);
        }

    }

    private static boolean isValid(char[] braces) {
        Stack<Character> stack = new Stack<>();
        for (char c : braces) {
            if (stack.isEmpty()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    return false;
                }
            } else {
                if (c == ')') {
                    if (stack.peek() != '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    // 闭合法
    // TODO 理解
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    // 回溯法
    // TODO 理解
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    // 第一步先保证能生成全部的括号组合
    // 第二步 在第一步的基础上尝试加入过滤条件 生成合法的括号集合
    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        // 左括号随时可以加 只要不用完
        // 右括号加的条件是左括号的个数 > 右括号的个数
        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
}
