class Solution {
    //最简单的写法当然是：使用api库
    public boolean isAnagram(String s, String t) {
        int count[] = new int[26];
        for(char a : s.toCharArray())
            count[a-'a']++;
        for(char b : t.toCharArray())
            count[b-'a']--;
        for(int a : count)
            if(a != 0)return false;
        return true;   
    }
}