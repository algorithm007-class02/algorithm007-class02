import java.util.HashMap;

class LeetCode_387_0236{
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> count = new HashMap();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}