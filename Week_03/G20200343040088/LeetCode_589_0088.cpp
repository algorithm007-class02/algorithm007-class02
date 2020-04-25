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
    vector<int> preorder(Node* root) {
        vector<int> ret;
        prorder(root, ret);
        return ret;
    }

    void prorder(Node* root, vector<int>& ret) {
        if (root == NULL) return;

        ret.push_back(root->val);
        for (int i = 0; i < root->children.size(); i++) {
            prorder(root->children[i], ret);
        }
    }
};