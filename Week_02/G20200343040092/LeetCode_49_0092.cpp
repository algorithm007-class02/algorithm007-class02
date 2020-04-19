#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::vector<std::vector<string>> res;
        std::unordered_map<std::string, std::vector<std::string>> keyToVariants;

        for (auto& str : strs) {
            std:string tmp = str;
            std::sort(tmp.begin(), tmp.end());
            keyToVariants[tmp].push_back(str);
        }

        for (auto& ele : keyToVariants) {
            res.push_back(ele.second);
        }
        
        return res;
    }
};
