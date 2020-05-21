class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, int> ums;
        unordered_map<char, int> umt;
        for(int i = 0; i < s.length(); ++i){
            auto sPos = ums.find(s[i]);
            auto tPos = umt.find(t[i]);
            int x = sPos == ums.end() ? -1 : ums[s[i]];
            int y = tPos == umt.end() ? -1 : umt[t[i]];
            if(x != y) return false;
            ums[s[i]] = i;
            umt[t[i]] = i;
        }
        return true;
    }
};


// class Solution {
// public:
//     bool isIsomorphic(string s, string t) {
//         vector<int> hash_s (128, 0);
//         vector<int> hash_t (128, 0);
//         for(int i = 0; i < s.length(); ++i){
//             if(hash_s[s[i]] != hash_t[t[i]]) return false;
//             hash_s[s[i]] = i + 1;
//             hash_t[t[i]] = i + 1;
//         }
//         return true;
//     }
// };
