import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.12%)
 * Likes:    289
 * Dislikes: 0
 * Total Accepted:    57.2K
 * Total Submissions: 93.6K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int[] nums = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(nums, 0);
            String word = strs[i];
            for (char c: word.toCharArray()) {
                nums[c - 'a'] += 1;
            }
            StringBuffer buf = new StringBuffer();
            for (int j = 0; j < nums.length; j++) {
                buf.append(nums[j]);
                buf.append("*");
            }
            String key = buf.toString();
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(word);
                map.put(key, list);
            }
        }
        List<List<String>> list = new ArrayList<List<String>>();
        list.addAll(map.values());
        return list;  
    }
}
// @lc code=end

