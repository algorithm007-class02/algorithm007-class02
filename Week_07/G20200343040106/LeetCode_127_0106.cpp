// 双向BFS

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> mmp = unordered_set<string>(wordList.begin(),wordList.end());
        if(mmp.find(endWord)==mmp.end()) return 0;  
        set<string> front;
        set<string> back;
        front.insert(beginWord);
        back.insert(endWord);
        
        int ans = 1;
        while(!front.empty()&&!back.empty()){
            if(front.size()>back.size()){
                swap(front,back);
            }
            ans++;
            vector<string> f = vector<string>(front.begin(),front.end());
            front.clear();
            for(auto s:f){
                for(int i=0;i<s.size();i++){
                    char temp = s[i];
                    for(char c='a';c<='z';c++){
                        s[i] = c;
                        if(back.find(s)!=back.end()){
                            return ans;
                        }
                        if(mmp.find(s)!=mmp.end()){
                            front.insert(s);
                            mmp.erase(s);
                        }
                    }
                    s[i] = temp;
                }
            }
        }

        return 0;
    }
};