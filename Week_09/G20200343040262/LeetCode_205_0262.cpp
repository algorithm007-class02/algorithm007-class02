/*
 * @lc app=leetcode.cn id=205 lang=cpp
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> smap;
        unordered_map<char, char> tmap;
        for (int i = 0; s[i] != '\0'; ++i) {
            char ss = s[i];
            char tt = t[i];
            if (smap.count(ss)) {
                if (smap[ss] != tt)
                    return false;
            } else if (tmap.count(tt)) {
                if (tmap[tt] != ss)
                    return false;
            } else {
                smap[ss] = tt;
                tmap[tt] = ss;
            }
        }
        return true;
    }
};
// @lc code=end
