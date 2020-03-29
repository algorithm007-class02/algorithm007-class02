class Solution {
public:
    vector<int> postorder(Node* root) {
        std::vector<int> res;
        PostOrder(root, res);   
        return res;
    }

    void PostOrder(Node* node, std::vector<int> &res) {
        if (node == nullptr) {
            return;
        }

        for(int i = 0; i < (node->children).size(); i++) {
            PostOrder((node->children)[i], res);
        }
        res.push_back(node->val);
    }
};
