//�����Ŀ�ж��ֽⷨ��
// ���ھ�������&�������ϰ&DP����Ὣ
// ֻ�����ݹ�Ľⷨ��
// ����ģ���д�����졣

class Solution {
public:
    vector<string> ans;
    vector<string> generateParenthesis(int n) {
        trace(0,0,n,"");
        return ans;
    }
    void trace(int left,int right,int n,string s){
        if(left==n&&right==n){
            ans.push_back(s);
            return ;
        }
        if(left<n){
            trace(left+1,right,n,s+"(");
        }
        if(left>right){
            trace(left,right+1,n,s+")");
        }
        return ;
    }
}; 
