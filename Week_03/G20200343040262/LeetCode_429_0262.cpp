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
//思路：利用队列实现
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (root == NULL) return  res;
        queue<Node*> q;
        q.push(root);
        while (!q.empty()) {
            vector<int> level;
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Node* tmp = q.front();
                level.push_back(tmp -> val);
                q.pop();
                for (auto j : tmp -> children) {
                    q.push(j);
                }
            }
            res.push_back(level);
        }
        return res;
    }
};