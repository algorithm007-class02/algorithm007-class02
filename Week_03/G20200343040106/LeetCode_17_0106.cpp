#include<vector>
#include<string>
using namespace std;
// 回溯算法
class Solution {
public:
    vector<string> hash;
    vector<string> ans;
    vector<string> letterCombinations(string digits) {
        if(digits=="")
            return ans;
        // build hash map
        hash.push_back("abc");
        hash.push_back("def");
        hash.push_back("ghi");
        hash.push_back("jkl");
        hash.push_back("mno");
        hash.push_back("pqrs");
        hash.push_back("tuv");
        hash.push_back("wxyz");
        string substr = "";
        traceBack(substr,0,digits);
        return ans;
    }
    void traceBack(string &subans,int curIndex,string digits){
        // terminator
        if(curIndex==digits.size()){
            ans.push_back(subans);
            return ;
        }
        // process current node
        int curNode = digits[curIndex]-'2';
        // drill down
        for(int i=0;i<hash[curNode].size();i++){
            subans.push_back(hash[curNode][i]);
            traceBack(subans,curIndex+1,digits);
            //reverse
            subans.pop_back();
        }
        return ;
    }
};