class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        set<string> setList;
        for (auto str : wordList) {
            setList.insert(str);
        }

        if (setList.find(endWord) == setList.end()) return 0;

        char szword[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int ret = 0;

        queue<string> queueHelp;

        queueHelp.push(beginWord);

        while (!queueHelp.empty()) {
            int size = queueHelp.size();
            ret++; // 这里是放每一层的
            for ( int j = 0; j < size; j++) {
                string strfront = queueHelp.front();
                queueHelp.pop();
                if (endWord == strfront) { return ret;}

                for (int i = 0; i < strfront.size(); i++) {
                    char old = strfront[i];

                    for (int k = 0; k < sizeof(szword) / sizeof(szword[0]); k++) {
                        strfront[i] = szword[k];
                    
                        if (setList.find(strfront) != setList.end()) {
                            queueHelp.push(strfront);
                            setList.erase(strfront);                        
                        }
                    }

                    strfront[i] = old;
                }
            }
        }

            return 0;
        }
    
};

// bfs