import java.util.HashMap;
import java.util.Map;

class Solution {
    //字母对应的下标相同则正确
    public boolean isIsomorphic1(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
                return false;
            }
        }
        return true;
    }


    //s->t 单词一一对应，t->s单词一一对应 如：add egg   a->e  ,d->g    e->a  g->d
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }


    public boolean helper(String s, String t) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < len; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss)) {
                if (map.get(ss) != tt) {
                    return false;
                }
            } else {
                map.put(ss, tt);
            }
        }
        return true;
    }
}