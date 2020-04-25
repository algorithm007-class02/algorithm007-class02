//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if ( ( s.length() & 1 ) != 0 ) return false;
        if ( s == null ) return true;
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray() ) {
            if ( c == '(' ) stack.push(')');
            else if ( c == '{' ) stack.push('}');
            else if ( c == '[' ) stack.push(']');
            else if ( stack.empty() || c != stack.pop() ) return false;
            /**
             * stack.empty() 如果是 ()]] 这样的情况，则 stack 为空，括号无效，返回false
             * 同时也是防止pop时 stack 为 0 时抛出 EmptyStackException
             */


        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
