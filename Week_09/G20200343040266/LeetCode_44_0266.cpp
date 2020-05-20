class Solution {
public:
    vector<vector<int>> memo;
    bool isMatch(string s, string p) {
        memo=vector<vector<int>> (s.size()+1,vector<int>(p.size()+1,-1));
        return helper(s,p,0,0);
    }
    bool helper(string& s,string& p,int si,int pi) {
        if (memo[si][pi]!=-1) return memo[si][pi];
        if (si==s.size()||pi==p.size()) {
            if (si==s.size()&&pi==p.size()) return memo[si][pi]=true;
            else if (pi==p.size()) {
                return memo[si][pi]=false;
            } else {
                while (pi<p.size()&&p[pi]=='*') pi++;
                return memo[si][pi]=(pi==p.size());
            }
        }

        if (s[si]==p[pi]) memo[si][pi]=helper(s,p,si+1,pi+1);
        else if (p[pi]=='?') { 
            memo[si][pi]=helper(s,p,si+1,pi+1);
        } else if (p[pi]=='*') {
            memo[si][pi]=helper(s,p,si+1,pi)||helper(s,p,si,pi+1);
        } else memo[si][pi]=false;

        return memo[si][pi];
    }
};