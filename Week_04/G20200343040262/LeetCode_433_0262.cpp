//关键是理解题意，一次只能变化序列中的一个字符，且变化后的序列必须存在基因库中。
//采用BFS遍历，找出基因库中一次突变的所有序列，利用队列多次遍历，找到目标序列
class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        if (start.empty() || end.empty() || bank.empty()) return -1;
        if (find(bank.begin(), bank.end(), end) == bank.end()) return -1;
        
        int step = 0;
        queue<string> q;
        q.push(start);
        vector<int> visit(bank.size(), 0);//初始化visit数组，用做回溯剪枝

        while (!q.empty()) {
            step++;
            int width = q.size();
            for (int i = 0; i < width; i++) {
                string tmp = q.front();
                q.pop();
                for (int j = 0; j < bank.size(); j++) {
                    if (visit[j] == 0) {
                        int diff = 0;
                        for (int k = 0; k < tmp.size(); k++) 
                            if (tmp[k] != bank[j][k]) diff++;
                        if (diff == 1) {//找出基因库中一次基因突变后的合法序列
                            if (bank[j] == end) return step;
                            visit[j] = 1;
                            q.push(bank[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
};