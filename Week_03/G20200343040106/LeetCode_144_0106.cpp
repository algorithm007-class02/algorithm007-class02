// �������������
// ˼·��ģ���⣬�������������һ��
// �������������Ҫ�ڵ�ջʱ���ʣ��������������ջʱ���ʡ�
// ���ڵݹ�д��̫�򵥣�����ֻ����ջģ�ⷽ����

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        TreeNode* p = root;
        vector<int> ans;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
            	//�����������������ջʱ���ʽ�� 
                ans.push_back(p->val);
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                p = p->right;
            }
        }
        return ans;
    }
}; 
