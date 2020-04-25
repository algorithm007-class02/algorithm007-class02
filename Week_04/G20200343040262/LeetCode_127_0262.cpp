class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if (wordList.empty()) return 0;
        if (find(wordList.begin(), wordList.end(), endWord) == wordList.end()) return 0;

        int step = 1;
        queue<string> q;
        q.push(beginWord);
        vector<int> visit(wordList.size(), 0);//backtrack

        while(!q.empty()) {
            step++;
            int width = q.size();
            for (int i = 0; i < width; i++) {
                string tmp = q.front();
                q.pop();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visit[j] == 0) {
                        int diff = 0;
                        for (int k = 0; k < tmp.size(); k++) {
                            if (tmp[k] != wordList[j][k]) diff++;
                        }
                        if (diff == 1) {
                            if (wordList[j] == endWord) return step;
                            visit[j] = 1;
                            q.push(wordList[j]);
                        }
                    }
                }
            }
        }
        return 0;
    }
};