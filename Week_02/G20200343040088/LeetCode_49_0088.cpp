class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        for (auto s : strs) {
            string str = s;
            sort(str.begin(), str.end());
            mp[str].push_back(s);
        }

        vector<vector<string>> ret;
        for (auto p : mp) {
            ret.push_back(p.second);
        }

        return ret;
    }
};