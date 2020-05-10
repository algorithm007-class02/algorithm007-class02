public class LeetCode_547_0236 {

    public int findCircleNum(int[][] M) {
        int result = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                result++;
                DFS(M,visited,i);
            }
        }
        return result;
    }

    private void DFS(int[][] M, int[] visited, int i){
        for (int j = 0; j < M.length; j++) {
            if (M[i][j]==1 && visited[j]==0) {
                visited[j] = 1;
                DFS(M,visited,j);
            }
        }
    }
    
}