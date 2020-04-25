class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int ans = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                ans++;
                dfs(M, i, visited);
            }
        }
        return ans;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for(int j = 0; j < M.length; j++) {
            if (visited[j]) continue;
            if(M[i][j] == 1) {
                dfs(M, j, visited); //去寻找下一层，此时visited[j]一定为false
            }
        }
    }
}