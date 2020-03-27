// 中序遍历二叉树
// 思路：模板题
// 区别：中序遍历需要在弹栈时访问，而先序遍历在入栈时访问。
// 由于递归写法太简单，这里只给你栈模拟方法。

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        TreeNode* p = root;
        vector<int> ans;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                ans.push_back(p->val);
                p = p->right;
            }
        }
        return ans;
    }
};
