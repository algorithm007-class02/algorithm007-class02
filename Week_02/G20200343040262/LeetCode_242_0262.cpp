/*
思路：
1、暴力法，sort字符串，然后比较字符串是否相等？O(NlogN)
2、hash_map 统计每个字符的频次，比较是否相等
*/
//这里采用数组代替更快
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
        int hash[26]={0};
        for(auto n:s)
            hash[n-'a']++;
        for(auto n:t)
            hash[n-'a']--;
        for(int i=0;i<26;i++)
            if(hash[i]!=0)   return false;
        return true;
    }
};