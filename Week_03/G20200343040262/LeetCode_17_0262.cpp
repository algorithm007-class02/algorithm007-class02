class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        string charmap[10] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.size();
        if (n == 0) return res;
        res.push_back("");
        for (int i = 0; i < n; i++) {
            vector<string> tmp;
            string chars = charmap[digits[i] - '0'];
            for (int j = 0; j < chars.size(); j++) {
                for (int k = 0; k < res.size(); k++)
                    tmp.push_back(res[k] + chars[j]);
            }
            res = tmp;
        }
        return res;
    }
};