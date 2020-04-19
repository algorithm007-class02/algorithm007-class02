/*
广度优先搜索
时间复杂度：O(M×N)
空间复杂度：O(M×N)
*/
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int len = beginWord.size();    
        unordered_map<string, vector<string>> allComboDict;

        for (auto word : wordList) {
            for (int i = 0; i < len; i++) {
                string newWord = word.substr(0, i) + "*" + word.substr(i + 1, len - i - 1);
                if (allComboDict.find(newWord) != allComboDict.end())
                    allComboDict[newWord].push_back(word);
                else { 
                    allComboDict.insert(make_pair(newWord, vector<string>(1, word)));
                }       
            }
        }

        queue<pair<string, int>> q;
        q.push(make_pair(beginWord, 1));

        unordered_map<string, bool> visited;
        visited.insert(make_pair(beginWord, true));

        while(!q.empty()) {
            pair<string, int> node = q.front();
            q.pop();
            string word = node.first;
            int level = node.second;

            for(int i = 0; i < len; i++) {
                string newWord = word.substr(0, i) + "*" + word.substr(i + 1, len - i - 1);
                for (auto adjacentWord : allComboDict[newWord]) {
                    if (adjacentWord == endWord) 
                        return level + 1;
                    if (visited.find(adjacentWord) == visited.end()) {
                        q.push(make_pair(adjacentWord, level + 1));
                        visited.insert(make_pair(adjacentWord, true));
                    }
                }
            }
        }
        return 0;
    }
};

/*
双向广度优先搜索
时间复杂度：O(M×N)
空间复杂度：O(M×N)
*/
class Solution {    
public:
    Solution() {
        len = 0;
    }

    int visitedWordNode(queue<pair<string, int>>& q, 
                        unordered_map<string, int>& visited,
                        unordered_map<string, int>& other_visited) {
        pair<string, int> node = q.front();
        q.pop();
        string word = node.first;
        int level = node.second;

        for(int i = 0; i < len; i++) {
            string newWord = word.substr(0, i) + "*" + word.substr(i + 1, len - i - 1);
            for (auto adjacentWord : allComboDict[newWord]) {
                if (other_visited.find(adjacentWord) != other_visited.end())
                    return level + other_visited[adjacentWord];

                if (visited.find(adjacentWord) == visited.end()) {
                    q.push(make_pair(adjacentWord, level + 1));
                    visited.insert(make_pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if (find(wordList.begin(), wordList.end(), endWord) == wordList.end())
            return 0;

        len = beginWord.size();    
        for (auto word : wordList) {
            for (int i = 0; i < len; i++) {
                string newWord = word.substr(0, i) + "*" + word.substr(i + 1, len - i - 1);
                if (allComboDict.find(newWord) != allComboDict.end())
                    allComboDict[newWord].push_back(word);
                else { 
                    allComboDict.insert(make_pair(newWord, vector<string>(1, word)));
                }       
            }
        }

        queue<pair<string, int>> q_begin;
        q_begin.push(make_pair(beginWord, 1));
         queue<pair<string, int>> q_end;
        q_end.push(make_pair(endWord, 1));

        unordered_map<string, int> visited_beign;
        visited_beign.insert(make_pair(beginWord, 1));
        unordered_map<string, int> visited_end;
        visited_end.insert(make_pair(endWord, 1));

        while(!q_begin.empty() && !q_end.empty()) {
            int ans = visitedWordNode(q_begin, visited_beign, visited_end);
            if (ans > -1)
                return ans;
            
            ans = visitedWordNode(q_end, visited_end, visited_beign);
            if (ans > -1)
                return ans;  
        }
        return 0;
    }

public:
    int len;
    unordered_map<string, vector<string>> allComboDict;
};