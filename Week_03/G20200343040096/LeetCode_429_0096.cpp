/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
//迭代
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if(!root) return res;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            int n = q.size();
            vector<int> temp;
            for(int i = 0; i < n; ++i){
                Node* node = q.front();
                q.pop();
                temp.emplace_back(node->val);
                for(Node* tNode : node->children){
                    q.push(tNode);
                }
            }
            res.emplace_back(temp);
        }
        return res;
    }
};


//递归
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if(!root) return res;
        helper(res, root, 0);
        return res;
    }
    
    void helper(vector<vector<int>>& res, Node* root, int level){
        if(!root) {return;}
        if(res.size() <= level) res.emplace_back();
        res[level].emplace_back(root->val);
        for(auto node : root->children){
            helper(res, node, level + 1);
        }
    }
};