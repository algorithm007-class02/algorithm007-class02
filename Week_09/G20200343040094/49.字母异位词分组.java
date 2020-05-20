import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            String key = hash(str);
            if(!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    private String hash(String s){
        int[] counter = new int[26];
        for(char ch: s.toCharArray()) counter[ch - 'a']++;
        return Arrays.toString(counter);
    }
}
// @lc code=end

