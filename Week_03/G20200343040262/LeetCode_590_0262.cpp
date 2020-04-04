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
    vector<int> postorder(Node* root) {
        vector<int> res;
        if (root) {
            stack<Node*> S;
            S.push(root);
            while (!S.empty()) {
                Node* node = S.top();
                S.pop();
                res.push_back(node -> val);
                if (!node -> children.empty()) {
                    int n = node -> children.size();
                    for (int i = 0; i < n; i++) {//子树按 左右 顺序入栈
                        if (node -> children[i]) S.push(node -> children[i]);
                    }
                }
            }
        }
        reverse(res.begin(),res.end());//本是 根右左 顺序出栈，反转后即得后序遍历
        return res;
    }
};