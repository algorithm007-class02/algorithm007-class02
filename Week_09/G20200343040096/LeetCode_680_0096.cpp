class Solution {
public:
  //这个地方 传引用 很重要！！
  //这个地方 传引用 很重要！！
  //这个地方 传引用 很重要！！
    bool helper(const string& s, int i, int j, int count){
        if(count >= 2) return false;
        if(j <= i) return true;
        if(s[i] == s[j]) return helper(s, i + 1, j - 1, count);
        else{
            return helper(s, i + 1, j, count + 1) || helper(s, i, j - 1, count + 1);
        }
    }

    bool validPalindrome(string s) {
        return helper(s, 0, s.length() - 1, 0);
    }
};
