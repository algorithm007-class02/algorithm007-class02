class Solution {

  public int findCircleNum(int[][] M) {
    int peopleCount = M.length;
    int[] visited = new int[peopleCount];

    int count = 0;
    for (int i = 0; i < peopleCount; i++){
      if (visited[i] == 0){
        dfs(M, visited, i, peopleCount);
        count++;
      }
    }

    return count;
  }

  //深搜
  private void dfs(int[][] M, int[] visited, int i, int peopleCount){
    for (int j = 0; j < peopleCount; j++){
      if (M[i][j] == 1 && visited[j] == 0){
        visited[j] = 1;
        dfs(M, visited, j, peopleCount);
      }
    }
  }

}