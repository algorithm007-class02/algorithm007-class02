/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 */

// @lc code=start
//双向BFS
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        //字典中没有endWord，直接退出
        if (dict.find(endWord) == dict.end()) {
            return 0;
        }
        unordered_set<string> beginSet, endSet, tmp, visited;
        beginSet.insert(beginWord);
        endSet.insert(endWord);
        int len = 1;
        while (!beginSet.empty() && !endSet.empty()) {
            //交换beginSet和endSet，每次都从最小集合分叉，以最快地从两边往中间搜索
            if (beginSet.size() > endSet.size()) {
                tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            tmp.clear();
            for (string word : beginSet) {
                for (int i = 0; i < word.size(); i++) {
                    char old = word[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) {
                            continue;
                        }
                        word[i] = c;
                        // terminator
                        if (endSet.find(word) != endSet.end()) {
                            return len + 1;
                        }
                        //未访问过，且字典中存在word，则加入访问记录且加入tmp作为下一步要分叉的节点
                        if (visited.find(word) == visited.end() && dict.find(word) != dict.end()) {
                            tmp.insert(word);
                            visited.insert(word);
                        }
                    }
                    word[i] = old;
                }
            }
            //更新beginSet
            beginSet = tmp;
            len++;
        }
        return 0;
    }
};
// @lc code=end
