//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        func(digits,"",0);
        return result;
    }
    void func(String str,String letter,int index) {
        if (index == str.length()) {
            result.add(letter);
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0';
        String mapString = phoneMap[pos];
        for ( int i = 0; i < mapString.length(); i++ ) {
            func(str,letter + mapString.charAt(i),index + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
