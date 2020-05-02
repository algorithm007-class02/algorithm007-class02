class Solution {
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];

        for (char sChar : s.toCharArray()) {
            ++temp[sChar - 'a'];
        }

        for (char tChar : t.toCharArray()) {
            --temp[tChar - 'a'];
        }

        for (int item : temp) {
          if (item != 0) return false;  
        } 
        return true;
    }
}