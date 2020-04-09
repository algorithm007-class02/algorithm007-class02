//BFS

class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        int ans = 0;
        unordered_map<string,bool> isvisited;
        unordered_map<string,bool> bankRecord;
        for(int i=0;i<bank.size();i++){
            bankRecord[bank[i]] = true;
        }
        vector<char> symbol = {'A','C','G','T'};
        queue<string> q;
        q.push(start);
        isvisited[start] = true;
        while(!q.empty()){
            ans++;
            int n = q.size();
            for(int i=0;i<n;i++){
                string t = q.front();
                q.pop();
                if(t==end){
                    return ans;
                }
                for(int m=0;m<t.size();m++){
                    char temp = t[m];
                    for(int n=0;n<4;n++){
                        t[m] = symbol[n];
                        if(bankRecord[t]&&!isvisited[t]){
                            isvisited[t] = true;
                            q.push(t);
                        }
                    }
                    t[m] = temp;
                }
            }
        }

        return -1;
    }
};