#include <iostream>
#include <vector>
using namespace std;
/**
 
 144. 二叉树的前序遍历
 
 给定一个二叉树，返回它的 前序 遍历。
 */


struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> v;
        __preorderTraversal(root, v);
        return v;
    }
    
    void __preorderTraversal(TreeNode* root, vector<int>& v) {
        if (root != NULL) {
            v.push_back(root->val);
            __preorderTraversal(root->left, v);
            __preorderTraversal(root->right, v);
        }
    }
};

int main(int argc, const char * argv[]) {
    
    
    TreeNode node = TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    
    node.left->left = new TreeNode(4);
    node.left->right = new TreeNode(5);
    
    node.right->left = new TreeNode(6);
    node.right->right = new TreeNode(7);
    
    
    Solution s;
    vector<int> v = s.preorderTraversal(&node);
    
    for (auto& e : v) {
        cout << e <<endl;
    }
    
    return 0;
}