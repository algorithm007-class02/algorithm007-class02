/*
*Leetcode 221 最大正方形
*初始化左边界与上边界
*dp[i][j]=0 if matrix[i][j]=='0'
*dp[i][j]=min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1;
*/


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int L1=matrix.length,L2=matrix[0].length;
        int[][] dp=new int[L1][L2];
        int i,j;
        int count=0;
        for(i=0;i<L2;i++) {
	if(matrix[0][i]=='1'){
		dp[0][i]=1;count=1;
		}
	}
        for(i=1;i<L1;i++){
	 if(matrix[i][0]=='1'){
		dp[i][0]=1;count=1;
		}
	}


        for(i=1;i<L1;i++){
            for(j=1;j<L2;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                count=Math.max(count,dp[i][j]);
            }
        }
        return count*count;
    }
}

