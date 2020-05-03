class Solution {
    List<String> list = null;
    public List<String> generateParenthesis(int n) {
         list = new ArrayList<>();
        if(n <= 0)
            return list;
        char result[] = new char[n*2];
        dfs(result , n , 0 , 0 , 0);
        return list;
    }
    public void dfs(char[] result , int n , int floor , int left , int right){
        if(n*2 == (left + right)){
            list.add(new String(result));
            return;
        }
        if(left < n){
            result[floor] = '(';
            dfs(result,n,floor+1,left+1,right);
        }
        if(right < left){
            result[floor] = ')';
            dfs(result , n , floor + 1 , left , right + 1);
        }
    }
}