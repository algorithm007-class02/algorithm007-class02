
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> ans;
        if(!root)
            return ans;
        queue<Node*> q[2];
        int robin = 0;
        q[0].push(root);
        vector<int> temp;
        while(!q[robin].empty()){
            Node* t = q[robin].front();
            q[robin].pop();
            temp.push_back(t->val);
            vector<Node*> child = t->children;
            for(auto i:child){
                if(i) q[(robin+1)%2].push(i);
            }
            if(q[robin].empty()){
                ans.push_back(temp);
                temp.clear();
                robin = (robin+1)%2;
            }
        }
        return ans;
    }
};
