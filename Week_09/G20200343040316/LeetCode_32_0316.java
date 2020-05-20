package com.wxs.algorithm1.week09;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_32_0316 {

    public static void main(String[] args) {
        String s = "abcdef";

        String substring = s.substring(0, 2);
        System.out.println(substring);
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();

                if(stack.empty()){
                    stack.push(i);
                }else {
                    maxans= Math.max(maxans,i-stack.peek());
                }
            }

        }

        return maxans;

    }
}
