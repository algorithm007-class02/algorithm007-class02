// 上来没什么思路，暴力枚举
class Solution {
public:
    int ans ;
    int longestValidParentheses(string s) {
        ans = 0;
        int n = s.size();
        traceBack(s,0,s.size()-1);
        return ans;
    }
    void traceBack(string &s,int i,int j){
        //terminator
        if(i>=j) return ;
        if(isValid(s,i,j)){
            ans = max(ans,j-i+1);
            return ;
        }
        traceBack(s,i+1,j);
        traceBack(s,i,j-1);

        return ;
    }
    bool isValid(string &s,int l,int r){
        stack<char> stk;
        for(int i=l;i<=r;i++){
            if(s[i]=='(') stk.push(')');
            else if(stk.empty()||stk.top()!=s[i]) return false;
            else stk.pop();
        }
        return stk.empty();
    }
};
//不出意外的超时了，但至少确定了这种方法的正确性。
//牛逼哄哄的加个mem
class Solution {
public:
    int ans ;
    int longestValidParentheses(string s) {
        ans = 0;
        int n = s.size();
        vector<vector<bool>> mem = vector(n,vector<bool>(n,false));
        traceBack(s,0,s.size()-1,mem);
        return ans;
    }
    void traceBack(string &s,int i,int j,vector<vector<bool>> &mem){
        //terminator
        if(i>=j||mem[i][j]) return ;
        //cout<<i<<" "<<j<<endl;
        if(isValid(s,i,j)){
            //cout<<s<<" "<<i<<" "<<j<<" "<<"valid"<<endl;
            ans = max(ans,j-i+1);
            return ;
        }
        mem[i][j] = true;
        traceBack(s,i+1,j,mem);
        traceBack(s,i,j-1,mem);

        return ;
    }
    bool isValid(string &s,int l,int r){
        stack<char> stk;
        for(int i=l;i<=r;i++){
            if(s[i]=='(') stk.push(')');
            else if(stk.empty()||stk.top()!=s[i]) return false;
            else stk.pop();
        }
        return stk.empty();
    }
};

// 继续超时，这时候意识到方法有问题了，我上面的代码显然是个递归版本的暴力手段。丑陋且不优雅
// 看了题解，马上意识到自己上面对于f(i,j)搜索有问题。
// DP解法: 定义f(i)为以i结尾的最长有效括号的长度
// 当s[i]==')'且s[i-1]=='('时  f(i) = f(i-2)+2;
// 当s[i]==')'且s[i-1]==')'且s[i-1-f(i-1)]=='(' f(i) = f(i-1-f(i-1)-1)+f(i-1)+2;
// 当s[i]=='(' f(i) = 1;

class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        if(n<=1) return 0;
        int dp[n];
        int ans = 0;
        dp[0] = 0;
        for(int i=1;i<n;i++){
            dp[i] = 0;
            if(s[i]==')'&&s[i-1]=='('){
                dp[i] = i-2>=0?dp[i-2]+2:2;
            }else if(s[i]==')'&&s[i-1]==')'){
                int prelongest = i-2-dp[i-1]>=0?dp[i-2-dp[i-1]]:0;
                dp[i] = i-1-dp[i-1]>=0&&s[i-1-dp[i-1]]=='('?prelongest+dp[i-1]+2:0;
            }
            ans = max(ans,dp[i]);
        }   
        return ans;
    }

};
