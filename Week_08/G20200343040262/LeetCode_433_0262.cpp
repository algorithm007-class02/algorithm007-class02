/*
 * @lc app=leetcode.cn id=433 lang=cpp
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
public:
    int minMutation(string start, string end, vector<string> &bank) {
        unordered_set<string> dict(bank.begin(), bank.end());
        if (dict.find(end) == dict.end()) {
            return -1;
        }
        unordered_set<string> beginSet, endSet, tmp, visited;
        beginSet.insert(start);
        endSet.insert(end);
        int len = 0;
        while (!beginSet.empty() && !endSet.empty()) {
            if (beginSet.size() > endSet.size()) {
                tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            tmp.clear();
            for (string gene : beginSet) {
                for (int i = 0; i < gene.size(); i++) {
                    char old = gene[i];
                    char seq[4] = {'A', 'C', 'G', 'T'};
                    for (char c : seq) {
                        if (old == c) {
                            continue;
                        }
                        gene[i] = c;
                        if (endSet.find(gene) != endSet.end()) {
                            return len + 1;
                        }
                        if (visited.find(gene) == visited.end() && dict.find(gene) != dict.end()) {
                            tmp.insert(gene);
                            visited.insert(gene);
                        }
                    }
                    gene[i] = old;
                }
            }
            beginSet = tmp;
            len++;
        }
        return -1;
    }
};
// @lc code=end
