//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        unionFind union = new unionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) continue;
                if (M[i][j] == 1)
                    union.union(i,j);
            }
        }
        int[] arr = union.parent;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == -1)
                count++;
        }
        return count;
    }
    class unionFind {
        private int[] parent;
        private int[] rank;

        public unionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            if (parent[p] == -1) return p;
            int curP = p;
            while (parent[p] != -1) {
                p = parent[p];
            }
            //将查找到的节点指向根节点
            parent[curP] = p;
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            if (rank[pRoot] > rank[qRoot]) parent[qRoot] = pRoot;
            else if (rank[pRoot] < rank[qRoot]) parent[pRoot] = qRoot;
            else {
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
