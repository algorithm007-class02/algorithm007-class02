class Solution {
public:
    vector<int> preorder(Node* root) {
        std::vector<int> res;
        PreOrder(root, res);   
        return res;
    }

    void PreOrder(Node* node, std::vector<int> &res) {
        if (node == nullptr) {
            return;
        }
        res.push_back(node->val);
        for(int i = 0; i < (node->children).size(); i++) {
            PreOrder((node->children)[i], res);
        }

    }
};
