//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isAnagram(String s, String t) {
        // 1.排序看是否相同，O(nlogn)
        // 2.哈希表存字母出现次数，看每项是否为0, O(n)
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) return false;
        }
        for (int cnt : counter) if (cnt != 0) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
