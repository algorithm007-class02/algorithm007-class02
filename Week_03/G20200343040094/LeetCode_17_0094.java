/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<String>();
        search("", 0, digits, res, map);
        return res;
    }

    private void search(String s, int i, String digits, List<String> res, Map<Character, String> map){
        if (i == digits.length()){
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++){
            search(s+letters.charAt(j), i+1, digits, res, map);
        }
    }
}
// @lc code=end

