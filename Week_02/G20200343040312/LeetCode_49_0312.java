//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

/**
 * 自己的思考：
 * 自己想到先排序字符了，但是不知道如何返回成结果这样子的结构，
 * java功底不足限制了自己T-T*/
/**
 * 查看解答后：
 *  官方解法一的思想和自己的一样，学习，后面要多敲几遍
 *  另外，阿里代码规范还是要给if带大括号
 *
 *  官方题解的方法二感觉反而做麻烦了
 *  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * 方法一*/
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

        /*
        * 方法二*/
//        if (strs.length == 0){
//            return new ArrayList();
//        }
//        Map<String, List> ans = new HashMap<String, List>();
//        int[] count = new int[26];
//        for (String s : strs) {
//            Arrays.fill(count, 0);
//            for (char c : s.toCharArray()){
//                count[c - 'a']++;
//            }
//            StringBuilder sb = new StringBuilder("");
//            for (int i = 0; i < 26; i++) {
//                sb.append('#');
//                sb.append(count[i]);
//            }
//            String key = sb.toString();
//            if (!ans.containsKey(key)){
//                ans.put(key, new ArrayList());
//            }
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
