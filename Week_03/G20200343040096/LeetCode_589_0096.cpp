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
    vector<int> preorder(Node* root) {
        vector<int> res;
        helper(res, root);
        return res;
    }

    void helper(vector<int>& res, Node* root){
        if(!root) return;
        res.emplace_back(root->val);
        for(auto node : root->children){
            helper(res, node);
        }
    }
};

//迭代
class Solution {
public:
    vector<int> preorder(Node* root) {
        stack<Node*> stk;
        vector<int> res;
        Node* cur = root;
        while(cur || !stk.empty()){
            if(!cur) {
                cur = stk.top();
                stk.pop();
            }
            res.emplace_back(cur->val);
            for(int i = cur->children.size() - 1; i > 0; --i){
                stk.push(cur->children[i]);
            }
            if(!cur->children.empty()) {
                cur = cur->children[0];
            }else{
                cur = nullptr;
            }
        }
        return res;
    }
};
//迭代版优化  
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        if(!root) return res;
        stack<Node*> stk;
        stk.push(root);
        while(!stk.empty()){
            Node* cur = stk.top(); stk.pop();
            res.emplace_back(cur->val);
            for(int i = cur->children.size() - 1; i >= 0; --i){
                stk.push(cur->children[i]);
            }
        }
        return res;
    }
};