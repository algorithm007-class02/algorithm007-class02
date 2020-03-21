class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] nums1 = new int[26];        
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            nums1[a - 'a']++;
            nums1[b - 'a']--;
        }

        for (int i= 0 ; i < nums1.length; i++){
            if (nums1[i] != 0){
                return false;
            }
        }
        return true;
    }
}