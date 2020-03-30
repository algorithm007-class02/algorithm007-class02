/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=589 lang=cpp
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
class Solution {
public:
    //方法一：递归
    vector<int> preorder1(Node* root) {
        helper(root);
        return res;
    }
    //方法二：迭代
    vector<int> preorder(Node* root) {
        vector<int> v;
        if(!root)
            return v;
        stack<Node*> s;
        s.push(root);
        while (!s.empty())
        {
            Node* curr = s.top();
            v.push_back(curr->val);
            s.pop();
            for (int i = curr->children.size() - 1; i >=0; i--) {
                s.push(curr->children[i]);
            }
        }
        return v;
    }
private:
    vector<int> res;
    void helper(Node* root) {
        if (root) {
            res.push_back(root->val);
            for (int i = 0; i < root->children.size(); i++) {
                helper(root->children[i]);
            }
        } 
    }
};
// @lc code=end
