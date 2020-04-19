//recursion

class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        if(root->left==NULL&&root->right==NULL)
            return 1;
        int left=INT_MAX;
        int right=INT_MAX;
        if(root->left)
            left = minDepth(root->left);
        if(root->right)
            right = minDepth(root->right);
        return min(left,right)+1;
    }
};

//BFS

class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        int ans = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            ans++;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode* temp = q.front();
                q.pop();
                if(!temp->left&&!temp->right)
                    return ans;
                // add child
                if(temp->left)
                    q.push(temp->left);
                if(temp->right)
                    q.push(temp->right);
            }
        }
        return ans;
    }
};


 
