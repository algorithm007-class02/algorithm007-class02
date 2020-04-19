class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> m;
        vector<vector<string>> res;
        for(string str : strs){
            string temp = str;
            sort(temp.begin(), temp.end());
            if(m.count(temp) < 1) m[temp] = {str};
            else m[temp].emplace_back(str);
        }
        for(auto p : m){
            res.emplace_back(p.second);
        }
        return res;
    }
};