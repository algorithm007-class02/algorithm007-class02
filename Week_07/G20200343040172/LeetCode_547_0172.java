package week07.g20200343040172;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode_547_朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class LeetCode_547_0172 {

    /**
     * DFS 使用递归
     */
    class Solution1 {
        public void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }

        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                // 如果当前节点没被访问过，则进行DFS
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }
    }

    /*****************************************************/

    /**
     * BFS 使用队列
     */
    class Solution2 {
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
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
                    count++;
                }
            }
            return count;
        }
    }

    /*****************************************************/

    /**
     * 使用并查集
     */
    class Solution3 {
        private int[] parent;

        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0) {
                return 0;
            }
            int count = 0;
            int m = M.length;
            // 建立一个parent数组
            parent = new int[m];

            // 初始化parent数组
            for (int i = 0; i < m; i++) {
                // parent[i] = i表示当前节点指向它本身，也就是说它自身是一个单独的集合
                // 表示当前元素只有它自身这么一个集合，说明i为一个单独的集合
                parent[i] = i;
            }

            for (int i = 0; i < M.length; ++i) {
                for (int j = 0; j < M.length; ++j) {
                    if (M[i][j] == 1 && i != j) {
                        // 进行合并
                        union(i, j);
                    }
                }
            }
            for (int i = 0; i < parent.length; ++i) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }


        /**
         * find(x)：
         * 找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
         *
         * @param p
         * @return
         */
        public int find(int p) {
            while (p != parent[p]) {
                // parent[i] = m表示index = i这个节点的parent为m
                // 当前节点指向当前节点parent的parent，
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        /**
         * unionSet(x, y)：
         * 把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
         *
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            // 找到p的根节点
            int rootP = find(p);
            // 找到q的根节点
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
        }
    }
}

//
//class UnionFind {
//    private int count = 0;
//    private int[] parent;
//
//    /**
//     * 建立一个新的并查集，其中包含 s 个单元素集合。
//     * 如下的初始化是以parent[i] = i的形式进行初始化
//     * 有的初始化为parent[i] = -1
//     * @param n
//     */
//    public UnionFind(int n) {
//        count = n;
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    /**
//     * find(x)：
//     * 找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
//     * @param p
//     * @return
//     */
//    public int find(int p) {
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
//    }
//
//    /**
//     * unionSet(x, y)：
//     * 把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
//     * @param p
//     * @param q
//     */
//    public void union(int p, int q) {
//        int rootP = find(p);
//        int rootQ = find(q);
//        if (rootP == rootQ) {
//            return;
//        }
//        parent[rootP] = rootQ;
//        count--;
//    }
//}
