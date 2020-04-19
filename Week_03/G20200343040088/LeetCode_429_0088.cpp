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
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> ret;
        int level = 0;
        bfs(root, ret, level);
        return ret;
    }

    void bfs(Node* root, vector<vector<int>>& ret, int level) {
        if(root == NULL) return;
        if(ret.size() == level) ret.push_back({});

        ret[level].push_back(root->val);
        for (int i = 0; i < root->children.size(); i++) {
            bfs(root->children[i], ret, level + 1);
        } 
    }
};