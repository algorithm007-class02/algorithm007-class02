/*递归1
时间复杂度：O(N)
空间复杂度：O(N)*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        res = NULL;
        recursion(root, p, q);
        return res;
    }

    bool recursion(TreeNode* currentNode, TreeNode* p, TreeNode* q) {
        if (!currentNode)
            return false;

        int left = recursion(currentNode->left, p, q) ? 1 : 0;
        int right = recursion(currentNode->right, p, q) ? 1 : 0;
        int cur = (currentNode == p || currentNode == q) ? 1 : 0;
        if (left + right + cur >= 2)
            res = currentNode;
        
        return left + right + cur >= 1;
    }

    TreeNode* res;
};

/*递归2
时间复杂度：O(N)
空间复杂度：O(N)*/
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || p == root || q == root)
            return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        return !left ? right : !right ? left : root;
    }
};

/*使用父指针迭代
时间复杂度：O(N)
空间复杂度：O(N)*/
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        unordered_map<TreeNode*, TreeNode*> parent;
        deque<TreeNode*> stack;

        parent.insert(make_pair(root, (TreeNode*)NULL));
        stack.push_back(root);
        while (parent.find(p) == parent.end() || parent.find(q) == parent.end()) {
            TreeNode* node = stack.front();
            stack.pop_front();
            if (node->left) {
                parent.insert(make_pair(node->left, node));
                stack.push_back(node->left);
            }
            if (node->right) {
                parent.insert(make_pair(node->right, node));
                stack.push_back(node->right);
            }
        }

        set<TreeNode*> pParent;
        while (p) {
            pParent.insert(p);
            p = parent[p];
        } 

        while (pParent.find(q) == pParent.end()) {
            q = parent[q];
        }
        return q;
    }
};
