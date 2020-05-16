package Week_09.G20200343040246;

import java.util.HashMap;

public class LeetCode_387_0246 {
    
    public static void main(String[] args) {
        System.out.println(new LeetCode_387_0246().firstUniqChar("loveleetcode"));
        System.out.println(new LeetCode_387_0246().firstUniqChar1("loveleetcode"));
    }

    // Hash表统计字符个数
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCnt = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if (charCnt.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 通过字符下标判断是否唯一,并逐步前移下标值
    public int firstUniqChar1(String s) {
        int idx = s.length();
        for(int i = 'a'; i <= 'z'; i++){
            int start = s.indexOf(i);
            int end = s.lastIndexOf(i);
            if(start == end && start != -1){
                idx = Math.min(start, idx);
            }
        }
        return idx == s.length() ? -1 : idx;
    }

}