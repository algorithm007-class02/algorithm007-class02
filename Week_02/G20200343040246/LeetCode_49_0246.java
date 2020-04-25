package Week_02.G20200343040246;

import java.util.*;

//Java：字母异位词分组
public class LeetCode_49_0246 {
    public static void main(String[] args) {
        Solution solution = new LeetCode_49_0246().new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
        solution.groupAnagrams1(strs);
    }
    
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<List<String>>(ans.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i ++) {
                sb.append("#");
                sb.append(cnt[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<List<String>>(ans.values());
    }
}

}