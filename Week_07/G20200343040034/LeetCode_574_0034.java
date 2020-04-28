package com.alang.learn.week7;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_574_0034 {

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(M));
        System.out.println(solution.findCircleNum1(M));
        ;
    }

    static class Solution {
        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0) return 0;
            UnionFind unionFind = new UnionFind(M.length);
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1) unionFind.unionSet(i, j);
                }
            }
            return unionFind.count;
        }

        public int findCircleNum1(int[][] M) {
            if (M == null || M.length == 0) return 0;
            boolean[] visited = new boolean[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (!visited[i]) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] M, boolean[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(M, visited, j);
                }
            }
        }

        class UnionFind {
            int count;
            int[] parent;

            UnionFind(int count) {
                this.count = count;
                parent = new int[count];
                for (int i = 0; i < count; i++) parent[i] = i;
            }

            public int parent(int i) {
                int root = i;
                //压缩有2种 一种隔代压缩 一种是按照顺序全压缩
                while (parent[root] != root) root = parent[root];
                while (i != parent[i]) {
                    int temp = i;
                    i = parent[i];
                    parent[temp] = root;
                }
                /* 隔代压缩
                while (parent[root] != root) {
                    parent[root] = parent[parent[root]];
                    root = parent[root];
                }*/
                while (i != parent[i]) {
                    int temp = i;
                    i = parent[i];
                    parent[temp] = root;
                }
                return root;
            }

            void unionSet(int x, int y) {
                int xP = parent(x);
                int yP = parent(y);
                if (xP == yP) return;
                parent[xP] = yP;
                count--;
            }
        }
    }
}
