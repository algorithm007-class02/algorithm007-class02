class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> genBank = unordered_set<string>(bank.begin(),bank.end());
        if(genBank.find(end)==genBank.end()) return -1;
        char character[4] = {'A','C','G','T'};
        set<string> front;
        front.insert(start);
        set<string> back;
        back.insert(end);
        int ans = 0;
        while(!front.empty()&&!back.empty()){
            if(front.size()<back.size()){
                swap(front,back);
            }
            ans++;
            vector<string> f = vector<string>(front.begin(),front.end());
            front.clear();
            for(auto s:f){
                for(int i=0;i<s.size();i++){
                    char temp = s[i];
                    for(int j=0;j<4;j++){
                        s[i] = character[j];
                        if(back.find(s)!=back.end()){
                            return ans;
                        }
                        if(genBank.find(s)!=genBank.end()){
                            front.insert(s);
                            genBank.erase(s);
                        }
                    }
                    s[i] = temp;
                }
            }
        }
        return -1;
    }
};