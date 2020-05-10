/*
 * @lc app=leetcode.cn id=130 lang=cpp
 *
 * [130] 被围绕的区域
 */

// @lc code=start
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
private:
    //将二维坐标转化为一维坐标，便于并查集使用
    int flatten(int x, int y, int width) { return x * width + y; }

public:
    void solve(vector<vector<char>> &board) {
        if (board.size() == 0) {
            return;
        }
        int len = board.size();
        int width = board[0].size();
        int boardSize = width * len;
        unionFind uf(boardSize + 1);
        //添加一个虚拟节点，使得所有位于边界的'O'节点均与其连通
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || i == len - 1 || j == 0 || j == width - 1) && board[i][j] == 'O')
                    uf.union_set(flatten(i, j, width), boardSize);
            }
        }
        //再遍历搜索与上述集合相邻的'O'节点，添加到并查集中
        int dx[4] = {-1, 1, 0, 0};
        int dy[4] = {0, 0, -1, 1};
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < len && y >= 0 && y < width && board[x][y] == 'O') {
                            uf.union_set(flatten(x, y, width), flatten(i, j, width));
                        }
                    }
                }
            }
        }
        //将所有与边界'O'节点不相邻的'O'节点换成'X'
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && !uf.connected(flatten(i, j, width), boardSize))
                    board[i][j] = 'X';
            }
        }
    }
};
// @lc code=end
