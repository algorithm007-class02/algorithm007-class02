/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //这题需要重练！3.27
 //思路：序列化采用递归方法完成；反序列化借助栈来实现
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == NULL) return "";
        return to_string(root -> val) + "[" + serialize(root -> left) + "," + serialize(root -> right) + "]";
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stack<TreeNode*> s;
        TreeNode* root = NULL;
        string val;
        for (int i = 0; i < data.size(); ++i) {
            char t = data[i];
            if ((t >= '0' && t <= '9') || t == '-') {
                val += t;
            } else {
                if (i >= 1 && data[i - 1] != ']') {
                    TreeNode* node = NULL;
                    if (!val.empty())
                        node = new TreeNode(stoi(val));//stoi 将string转化为数值
                    if (root == NULL) 
                        root = node;
                    val.clear();
                    s.push(node);
                }
                if (t == ']' || t == ',') {
                    TreeNode* node = s.top();
                    s.pop();
                    if (!s.empty()) {
                        TreeNode* prev_node = s.top();
                        if (data[i] == ',')
                            prev_node->left = node;
                        else
                            prev_node->right = node;
                    }
                }
            }
        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));