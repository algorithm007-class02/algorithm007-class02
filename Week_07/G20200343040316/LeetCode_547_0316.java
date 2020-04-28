package com.wxs.algorithm1.week07;

/**
 * 类描述  ： 和岛屿问题虽然类似，但还是有所不同
 * 创建人  : 吴绪森
 * 创建时间：2020-04-24
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_547_0316 {


    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };


        LeetCode_547_0316 findCircleNum547 = new LeetCode_547_0316();

        int circleNum1 = findCircleNum547.findCircleNum(M);

        System.out.println(circleNum1);

    }


    public int findCircleNum(int[][] M) {


        int count = 0;
        int[] visited = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {

                dfs(M, visited, i);
                count++;
            }


        }

        return count;

    }

    private void dfs(int[][] m, int[] visited, int i) {

        for (int j = 0; j < m.length; j++) {

            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }

        }


    }


    public int findCircleNum1(int[][] M) {

        int n = M.length;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j < M.length; j++) {

                if(M[i][j] == 1) unionFind.union(i,j);

            }

        }


        return unionFind.count;




    }

}
