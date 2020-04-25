//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        func(result,"",0,0,n);
        return result;
    }
    public void func( List<String> result, String str, int left, int right, int n ) {
        if ( left == n && right == n ) {
            result.add(str);
            return;
        }
        if ( left < n ) func(result,str+"(",left+1,right,n);
        if ( left > right ) func(result,str+")",left,right+1,n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
