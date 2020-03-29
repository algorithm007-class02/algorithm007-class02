class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string,vector<string> > record;
        for(int i=0;i<strs.size();i++){
            string temp = mysort(strs[i]);  //这里mysort是利用计数排序，O(N) 
            record[temp].push_back(strs[i]);
        }
        for(auto i:record){
            ans.push_back(i.second);
        }
        return ans;
    }
    string mysort(string s){
        int ch[26] = {0};
        string ans = "";
        for(auto i:s){
            ch[i-'a']++;
        }
        for(int i=0;i<26;i++){
            ans+=string(ch[i],i+'a');
        }
        return ans;
        
    }
};
