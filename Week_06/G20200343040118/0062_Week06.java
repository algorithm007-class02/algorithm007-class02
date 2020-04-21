class Solution {
    public int uniquePaths(int m, int n) {
        int []array = new int[m];
        array[0] = 1;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++){
                //因为第一列全部都是1不需要更改,和第一行全部都是1
                if(j>0)
                    array[j]+=array[j-1];
            }
            return array[m-1];
    }
  
}