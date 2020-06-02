import java.util.Arrays;

class Solution {
    /**
     * 利用字母排序进行对比
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    /**
     * 哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] res = new int[26];
        for(int i = 0;i < s.length();i++){
            res[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < t.length();i++){
            res[t.charAt(i) - 'a']--;
            if(res[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}