class Solution {
    public boolean validPalindrome(String s) {
        for(int i = 0,j = s.length() - 1;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return helper(s,i,j-1) || helper(s,i+1,j);
            }
        }
        return true;
    }
    public boolean helper(String s,int i,int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}