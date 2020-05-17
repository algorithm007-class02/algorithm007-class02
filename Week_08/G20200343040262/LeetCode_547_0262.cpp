/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * 1.并查集(disjoint Set)
 * a. N --> 各自独立集合
 * b. 遍历好友关系矩阵 M : M[i][j] --> 合并
 * c. 看有多少孤立的集合
 * 2.DFS
 */
// 1. 并查集
class unionFind {
private:
    int count = 0;
    vector<int> parent;
    vector<int> weight;

public:
    //初始化并查集
    unionFind(int n) {
        count = n;
        parent.resize(n);
        weight.resize(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }
    //查找p节点的根节点，即p所在集合的代表
    int find(int p) {
        while (p != parent[p]) {
            //路径压缩，最终所有树高都不会超过3
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    //判断p q节点是否连通，是否同属一个集合
    bool connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    //合并p q节点所在的集合
    void union_set(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        //小集合接在大集合上，控制树的高度在logn
        if (weight[rootP] > weight[rootQ]) {
            parent[rootQ] = rootP;
            weight[rootP] += weight[rootQ];
        } else {
            parent[rootP] = rootQ;
            weight[rootQ] += weight[rootP];
        }
        count--;
    }
    //返回集合总数
    int cnt() { return count; }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>> &M) {
        int n = M.size();
        unionFind uf(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union_set(i, j);
                }
            }
        }
        return uf.cnt();
    }
};
// @lc code=end
