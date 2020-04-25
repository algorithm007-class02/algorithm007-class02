// ˼·���������
// ����ʽ�� 
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* p = root;
        TreeNode* prev = NULL;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                if(prev!=NULL&&p->val<=prev->val)
                    return false;
                prev = p;
                p = p->right;
            }
        }
        return true;
    }
};
// �ݹ�ʽ��
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* pre = NULL;
        return helper(root,pre);
    }
    bool helper(TreeNode* root,TreeNode* &pre){
        if(root==NULL)
            return true;
        if(!helper(root->left,pre))
            return false;
        if(pre!=NULL&&pre->val>=root->val)
            return false;
        pre = root;
        return helper(root->right,pre);
        
    }
}; 

