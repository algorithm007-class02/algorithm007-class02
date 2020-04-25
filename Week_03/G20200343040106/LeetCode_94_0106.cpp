// �������������
// ˼·��ģ����
// �������������Ҫ�ڵ�ջʱ���ʣ��������������ջʱ���ʡ�
// ���ڵݹ�д��̫�򵥣�����ֻ����ջģ�ⷽ����

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        TreeNode* p = root;
        vector<int> ans;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                ans.push_back(p->val);
                p = p->right;
            }
        }
        return ans;
    }
};
