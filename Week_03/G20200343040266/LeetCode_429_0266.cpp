class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        bfs(root,res,0);
        return res;
    }
    void bfs(Node* root,vector<vector<int>>& res,int level){
        if (!root) return;
        if (res.size()==level) res.push_back({});
        res[level].push_back(root->val);
        for (int i=0;i<root->children.size();++i){
            bfs(root->children[i],res,level+1);
        }
    }
};