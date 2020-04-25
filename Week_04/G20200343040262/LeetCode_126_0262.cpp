class Solution {
public:
    void dfs(string& beginword, string& curr, vector<string> path, unordered_map<string, vector<string>>& neighbor, vector<vector<string>>& res)
    {
        if(curr == beginword) {
            //到达了迭代终点
            path.push_back(curr);
            reverse(path.begin(), path.end());
            res.push_back(path);
            return;
        }
        //这里的path记录状态，这是c++的一个技巧，状态使用传值，则每个节点都是一个全新的状态，无需状态重置。
        path.push_back(curr);
        for(auto word : neighbor[curr]){
            //对于邻接节点
            dfs(beginword, word, path, neighbor, res);
        }
        
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList)     
    {
        //两个关键的数据结构，每个节点的邻接节点（每个节点的下一层节点，只相差一个字符的）
        //存储每个节点所在的深度
        /*
        1)先使用BFS"建图"，在搜索过程中记录信息
        */
        vector<vector<string>> res;
        vector<string> path;
        if(std::find(wordList.begin(), wordList.end(), endWord) == wordList.end()) return res;
        
        unordered_map<string,int> depth;
        unordered_map<string, vector<string>> neighbor;
        //convert vector into hashset,or use boolean matrix
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        //vector<int> visited(wordList.size(),0);
        
        //BFS to get words neighbors(only next layers neighbors)
        depth[beginWord] = 1;
        queue<string> Q;
        Q.push(beginWord);
        //从begin到end建图
        while(!Q.empty()){
            string curr = Q.front();
            Q.pop();
            for(int i = 0; i < curr.size(); ++i){
                string temp = curr;
                for(char c = 'a'; c <= 'z'; ++c){
                    temp[i] = c;
                    if(wordSet.count(temp)) {
                        //如果修改的这个temp是被包含的,再字典里面
                        if(depth.count(temp) == 0){
                           //这个temp还没被添加进neighbor
                            Q.push(temp);
                            depth[temp] = depth[curr] + 1;//update depth map
                            neighbor[temp].push_back(curr);
                        }else if(depth[temp] == depth[curr] + 1){
                            neighbor[temp].push_back(curr);
                        }
                    }
                }
            }
        }
        dfs(beginWord, endWord, path, neighbor, res);
        return res;
    }
};