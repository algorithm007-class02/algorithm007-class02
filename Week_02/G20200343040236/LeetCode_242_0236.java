import java.util.Arrays;
class LeetCode_189_0236 {

    /**
     * 暴力法
     */
    public boolean isAnagram(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        String a = new String(char1);
        String b = new String(char2);
        return a.equals(b);
    }

    /**
     * 计数法
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i) - 'a'] ++;
            arr[t.charAt(i)- 'a'] --;
        }

        for(int i =0;i< arr.length ; i++){
            if(arr[i] < 0){
                return false ;
            }
        }
        return true;
    }
}