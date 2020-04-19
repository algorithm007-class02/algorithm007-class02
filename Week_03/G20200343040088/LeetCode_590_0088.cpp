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
    vector<int> postorder(Node* root) {
        vector<int> ret;
        poorder(root, ret);
        return ret;
    }

    void poorder(Node* root, vector<int>& ret) {
        if (root == NULL) return;
        
        for (int i = 0; i < root->children.size(); i++) {
            poorder(root->children[i], ret);
        }

        ret.push_back(root->val);
    }
};