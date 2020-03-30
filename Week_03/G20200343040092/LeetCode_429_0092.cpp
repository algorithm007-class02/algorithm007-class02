class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(root == nullptr) {
            return vector<vector<int>>{};
        }
        
        std::vector<std::vector<int>> vec2D;
        std::queue<Node*> que;
        que.push(root);

        while(que.size() > 0) {
            std::vector<int> vec1D;
            int n = que.size();
            for (int j = 0; j < n ; j++) {
                cout << que.size() << endl;
                Node* tmp = que.front();
                vec1D.push_back(tmp->val);
                for (int i = 0; i < tmp->children.size(); i++) {
                    que.push(tmp->children[i]);
                }
                que.pop();
            }
            vec2D.push_back(vec1D);
        }
        return vec2D;
    }
};
