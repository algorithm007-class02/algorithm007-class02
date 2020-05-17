/*
 * @lc app=leetcode.cn id=212 lang=cpp
 *
 * [212] 单词搜索 II
 */

// @lc code=start
// 1.暴力法
/**words遍历 --> board search
 * O(N * M * M * 4 ^ K)
 */
// 2.trie
/**a. all words --> Trie 构建起 prefix
 * b. board, DFS
 */
class Trie {
private:
    bool isEnd;
    Trie *next[26];

public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd = false;                 //标记该节点是否是一个串的结束
        memset(next, 0, sizeof(next)); //字母映射表
    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *node = this;
        for (char c : word) {
            if (node->next[c - 'a'] == nullptr) {
                node->next[c - 'a'] = new Trie();
            }
            node = node->next[c - 'a'];
        }
        node->isEnd = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *node = this;
        for (char c : word) {
            node = node->next[c - 'a'];
            if (node == nullptr) {
                return false;
            }
        }
        return node->isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *node = this;
        for (char c : prefix) {
            node = node->next[c - 'a'];
            if (node == nullptr) {
                return false;
            }
        }
        return true;
    }
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>> &board, vector<string> &words) {
        Trie trie;
        for (string a : words) {
            trie.insert(a);
        }
        unordered_set<string> res;
        vector<vector<bool>> vis(board.size(), vector<bool>(board[0].size(), true));
        //对board中每个字符进行遍历，来得到最终结果
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                string cur = "";
                cur += board[i][j];
                vis[i][j] = false;
                DFS(board, trie, vis, res, cur, i, j);
                vis[i][j] = true;
            }
        }
        vector<string> ret;
        for (string x : res) {
            ret.push_back(x);
        }
        return ret;
    }

    void DFS(vector<vector<char>> &board, Trie &trie, vector<vector<bool>> &vis, unordered_set<string> &res, string &cur, int x, int y) {
        //如果当前字符串不是前缀，直接返回
        if (!trie.startsWith(cur)) {
            return;
        }
        if (trie.search(cur)) {
            res.insert(cur);
        }
        //四向通路
        int dx[4] = {-1, 1, 0, 0};
        int dy[4] = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int _x = x + dx[i];
            int _y = y + dy[i];
            if (_x >= 0 && _x < board.size() && _y >= 0 && _y < board[0].size() && vis[_x][_y]) {
                vis[_x][_y] = false;
                cur += board[_x][_y];
                DFS(board, trie, vis, res, cur, _x, _y);
                cur = cur.substr(0, cur.size() - 1);
                vis[_x][_y] = true;
            }
        }
    }
};
// @lc code=end