
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> ans;
        if(!root)
            return ans;
        stack<Node*> s;
        s.push(root);
        while(!s.empty()){
            Node* p = s.top();
            s.pop();
            ans.push_back(p->val);
            vector<Node*> temp = p->children;
            for(int i=(int)temp.size()-1;i>=0;i--){
                if(temp[i])
                    s.push(temp[i]);
            }
        }
        return ans;
    }
};
