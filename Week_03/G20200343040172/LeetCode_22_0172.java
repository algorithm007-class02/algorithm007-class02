package week03.g20200343040172;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 实战题目
 * LeetCode-22 Generate parentheses
 */
public class LeetCode_22_0172 {

    /**
     * 采用递归的方式来解决
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private static void generate(int left, int right, int n, String s, List list) {
        // terminator
        if (left == n && right == n) {
            //fillter 过滤掉不合法的情况
            list.add(s);
            return;
        }
        // process current logic
        // drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")", list);
        }
        // restore current status
    }
}
