class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> ans;
        if(!root)
            return ans;
        stack<Node*> s;
        Node* lastVisited = root;
        s.push(root);
        while(!s.empty()){
            Node* p = s.top();
            s.pop();
            //采用TOP-DOWN编程方法
            if(isChild(p)||ChildContain(p,lastVisited)){
                ans.push_back(p->val);
                lastVisited = p;
            }else{
                s.push(p);
                vector<Node*> temp = p->children;
                //把p的子节点，从右往左入栈
                for(int i = (int)temp.size()-1;i>=0;i--){
                    if(temp[i]){
                        s.push(temp[i]);
                    }
                }
            }
        }
        return ans;
    }

    bool isChild(Node* root){
        vector<Node*> temp = root->children;
        for(auto i:temp){
            if(i)
                return false;
        }
        return true;
    }
    bool ChildContain(Node* root,Node* target){
        vector<Node*> temp = root->children;
        for(auto i:temp){
            if(i==target)
                return true;
        }
        return false;
    }
};
