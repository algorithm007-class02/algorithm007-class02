package Week_07.G20200343040246;

import java.util.Arrays;

public class LeetCode_547_0246 {
    public static void main(String[] args) {
        int[][] M = new int[][]{
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        System.out.println(new LeetCode_547_0246().findCircleNum(M));
        System.out.println(new LeetCode_547_0246().findCircleNum1(M));
    }

    // 方法一：深搜
    public int findCircleNum(int[][] M) {
        int cnt = 0;
        int[] visited = new int[M.length];
        for(int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    // 方法二：并查集
    public int findCircleNum1(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
}