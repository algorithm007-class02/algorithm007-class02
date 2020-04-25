#include <iostream>
#include <vector>
using namespace std;
/**
 
 94. 二叉树的中序遍历
 
 给定一个二叉树，返回它的中序 遍历
 
 */

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        
        vector<int> v;
        __inorderTraversal(root, v);
        return v;
    }
    
    void __inorderTraversal(TreeNode *root, vector<int>& v) {
        if (root != NULL) {
            __inorderTraversal(root->left, v);
            v.push_back(root->val);
            __inorderTraversal(root->right, v);
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
    
    Solution s = Solution();
    vector<int> v = s.inorderTraversal(&node);
    
    for (auto& e : v) {
        cout << e << endl;
    }
    
    
    return 0;
}

