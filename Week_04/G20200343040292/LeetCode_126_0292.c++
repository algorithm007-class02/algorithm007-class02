class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> ans;
        if (find(wordList.begin(), wordList.end(), endWord) == wordList.end())
            return ans;

        int len = beginWord.size();    
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

        unordered_map<string, vector<string>> map;
        bfs(beginWord, endWord, wordList, map);
        vector<string> temp;
        temp.push_back(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        
        return ans;
    }

    void findLaddersHelper(string& beginWord, string& endWord, unordered_map<string, vector<string>>& map, vector<string>& temp, vector<vector<string>>& ans) {
        if (beginWord == endWord) {
            ans.push_back(temp);
            return;
        }
        vector<string> neighbors = map[beginWord];
        for (auto node : neighbors) {
            temp.push_back(beginWord);
            findLaddersHelper(node, endWord, map, temp, ans);
            temp.pop_back();
        }
    }

   void bfs(string& beginWord, string& endWord, vector<string>& wordList, unordered_map<string, vector<string>>& map) {
        queue<string> queue;
        queue.push(beginWord);
        bool find = false;
        int depth = 0;
        set<string> dict;
        dict.insert(wordList.begin(), wordList.end());
        set<string> visited;
        visited.insert(beginWord);

        while (!queue.empty()) {
            int size = queue.size();
            depth++;
            set<string> subVisited;
            for (int i = 0; i < size; i++) {
                string temp = queue.front();
                queue.pop();
                vector<string> neighbors = getNeighbors(temp, dict);
                while (!neighbors.empty()) {
                    string neighbor = neighbors.front();
                    if (visited.find(neighbor) == visited.end()) {
                        if (neighbor == endWord) {
                            find = true;
                        }
                        queue.push(neighbor);
                        subVisited.insert(neighbor);
                    }
                    else {
                        neighbors.erase(neighbors.begin());
                    }
                    map.insert(make_pair(temp, neighbors));
                }
            }
            visited.insert(subVisited.begin(), subVisited.end());
            if (find)
                break;
        }
    }

    vector<string> getNeighbors(string& node, set<string>& dict) {
        vector<string> ans;
        int len = node.size();
        for(int i = 0; i < len; i++) {
            string newWord = node.substr(0, i) + "*" + node.substr(i + 1, len - i - 1);
            vector<string> neighbors = allComboDict[newWord];
            for (auto neighbor : neighbors) {
                if (neighbor != node)
                   ans.push_back(neighbor); 
            }
        }
        return ans;
    }

    unordered_map<string, vector<string>> allComboDict;
};