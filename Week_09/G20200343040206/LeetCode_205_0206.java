
//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
// 示例 1:
//
// 输入: s = "egg", t = "add"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "foo", t = "bar"
//输出: false
//
// 示例 3:
//
// 输入: s = "paper", t = "title"
//输出: true
//
// 说明:
//你可以假设 s 和 t 具有相同的长度。
// Related Topics 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_205_0206 {
    /**
     * 用map建立映射表，然后逐一比较
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map.containsKey(charS)) {
                if (map.get(charS) != charT) {
                    return false;
                }
            } else {
                map.put(charS, charT);
            }
        }
        return true;
    }

    /**
     * 使用映射函数，将每个字符第一次出现的位置进行转换，然后比较s,t转换出来的是否一样
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphi2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
