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
//思路二：迭代法
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        if (root) {
            stack<Node*> S;
            S.push(root);
            while (!S.empty()) {
                Node* node = S.top();
                res.push_back(node -> val);
                S.pop();
                if (!node -> children.empty()) {
                    int n = node -> children.size();
                    for (int i = n - 1;i >= 0; i--) {//入栈顺序和遍历时相反
                        if (node -> children[i]) S.push(node -> children[i]);
                    }
                }
            }
        }
        return res;
    }
};