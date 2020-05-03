package com.wxs.algorithm1.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class UnionFind1 {


    int count;

    int[] parent;

    public UnionFind1(int n) {

        count = n;
        parent = new int[count];
        for (int i = 0; i < n; i++) {
            parent[i] = i;

        }

    }


    public int find(int p){

        while (p != parent[p]){

            parent[p] = parent[parent[p]];

            p = parent[p];

        }
        return p;
    }

    public void union(int a, int b){


        int findA = find(a);
        int findB = find(b);
        if(findA == findB) return;
        parent[findA] = findB;
        count--;

    }




}
