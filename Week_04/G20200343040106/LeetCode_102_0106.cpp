// 二叉树层次遍历

//法一：队列
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root==NULL)
            return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            vector<int> temp;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode* t = q.front();
                q.pop();
                temp.push_back(t->val);
                if(t->left) q.push(t->left);
                if(t->right) q.push(t->right);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};

//法二：dfs
class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> levelOrder(TreeNode* root) {
        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode* root,int curLevel){
        if(root==NULL)
            return ;
        if(ans.size()<=curLevel){
            ans.push_back(vector<int>());
        }
        ans[curLevel].push_back(root->val);
        dfs(root->left,curLevel+1);
        dfs(root->right,curLevel+1);
        return ;
    }
};