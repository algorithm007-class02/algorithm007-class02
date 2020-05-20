
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 案例:
//
//
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
//
//
//
//
// 注意事项：您可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_387_0206 {
    /**
     * 1、暴力嵌套循环查找
     * 2、map记录个数
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
