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
//递归
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        helper(res, root);
        return res;
    }

    void helper(vector<int>& res, Node* root){
        if(!root) return;
        for(auto node : root->children){
            helper(res, node);
        }
        res.emplace_back(root->val);
    }
};


//迭代

