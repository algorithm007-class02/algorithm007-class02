//方法一
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, int> work;//判断排序后单词是否存在，即字母组成是否一致，储存单词对应的vector下标
        string tmp; //临时string
        int sub = 0; //结果vector的下标值

        for (auto str : strs) {
            tmp = str;
            sort(tmp.begin(), tmp.end());
            if (work.count(tmp)) {
                res[work[tmp]].push_back(str);
            }
            else {
                vector<string> vec(1, str);
                res.push_back(vec);
                work[tmp] = sub++;
            }
        }
        return res;
    }
};

//方法二，相比方法一多一遍循环
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;//储存排序后单词对应的单词列表
        string tmp;//临时string

        for (auto str : strs) {
            tmp = str;
            sort(tmp.begin(), tmp.end());
            mp[tmp].push_back(str);
        }

        vector<vector<string>> res;
        for (auto p : mp) {
            res.push_back(p.second);
        }
        return res;
    }
};