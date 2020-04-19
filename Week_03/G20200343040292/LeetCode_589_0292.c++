/*递归
时间复杂度：O(N)
空间复杂度：O(N)*/
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
        if (!root)
            return vector<int>();

        vector<int> res; 
        res.push_back(root->val);
        for (auto node : root->children) {
            vector<int> tmp = preorder(node);
            res.insert(res.end(), tmp.begin(), tmp.end());
        }
        return res;
    }
};