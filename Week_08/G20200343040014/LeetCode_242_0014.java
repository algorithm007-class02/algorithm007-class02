class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //计数排序
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            nums[a - 'a']++;
            nums[b - 'a']--;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0)return false;
        }
        return true;
    }
}