class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        int sub=0;
        string tmp;
        unordered_map<string,int> mp;
        for (auto str:strs){
            tmp=str;
            sort(tmp.begin(),tmp.end());
            if (mp.count(tmp)){
                res[mp[tmp]].push_back(str);
            } else {
                vector<string> v(1,str);
                res.push_back(v);
                mp[tmp]=sub++;
            }
        }
        return res;
    }
};