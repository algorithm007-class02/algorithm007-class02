package com.wxs.algorithm1.week07;

/**
 * 类描述  ： 并查集
 * 创建人  : 吴绪森
 * 创建时间：2020-04-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class UnionFind {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(5);

        unionFind.union(2, 3);


    }


    int count = 0;
    private int[] parent;

    public UnionFind(int n) {

        count = n;
        parent = new int[count];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

    }


    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;

    }


}
