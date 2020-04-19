package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    // 递归
    // 首先 字母是可以重复取的
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return res;
        Map<Character, String> config = new HashMap<>();
        config.put('2', "abc");
        config.put('3', "def");
        config.put('4', "ghi");
        config.put('5', "jkl");
        config.put('6', "mno");
        config.put('7', "pqrs");
        config.put('8', "tuv");
        config.put('9', "wxyz");
        loopHelper(res, "", 0, digits, config);
        return res;
    }

    private static void loopHelper(List<String> res, String S, int index, String digits,
            Map<Character, String> config) {
        if (index == digits.length()) {
            res.add(S);
            return;
        }
        // 这里 index 表示当前是第几个数字
        char data = digits.charAt(index);
        String strs = config.get(data);
        // 当前数字的每种取法的对应情况 继续往下一个数字去组合
        for (char s : strs.toCharArray()) {
            loopHelper(res, S + s, index + 1, digits, config);
        }
    }
}
