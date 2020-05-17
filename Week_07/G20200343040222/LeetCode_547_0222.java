public class LeetCode_547_0222 {

    /**
     * DFS 时间复杂度为 O(n^2) 空间复杂度为 o(n)
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }


    /**
     * bfs 时间复杂度：O(n^2) 空间复杂度为O(n)
     * @param M
     * @return
     */
    public int findCircleNumRe(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

    /**
     * 并查集 时间复杂度：O(n^3) 空间复杂度为O(n)
     * @param M
     * @return
     */
    public int findCircleNumReRe(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i , j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                res++;
            }
        }
        return res;
    }

    private void union(int[] parent, int i , int j) {
        int iRoot = find(parent, i);
        int jRoot = find(parent, j);
        if (iRoot != jRoot) {
            parent[iRoot] = jRoot;
        }
    }

    private int find(int[] parent, int index) {
        if (parent[index] == -1) {
            return index;
        }
        return find(parent, parent[index]);
    }
}