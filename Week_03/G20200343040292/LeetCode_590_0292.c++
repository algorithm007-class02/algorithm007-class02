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
    vector<int> postorder(Node* root) {
        vector<int> res;
        if (!root)
            return res;

        for (auto node : root->children) {
            vector<int> tmp = postorder(node);
            res.insert(res.end(), tmp.begin(), tmp.end());
        }
        res.push_back(root->val);
        return res;
    }
};