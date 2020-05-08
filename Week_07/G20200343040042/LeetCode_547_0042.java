/**
 * //班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
 * //的朋友。所谓的朋友圈，是指所有朋友的集合。
 * //
 * // 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
 * //必须输出所有学生中的已知的朋友圈总数。
 * //
 * // 示例 1:
 * //
 * //
 * //输入:
 * //[[1,1,0],
 * // [1,1,0],
 * // [0,0,1]]
 * //输出: 2
 * //说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * //第2个学生自己在一个朋友圈。所以返回2。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入:
 * //[[1,1,0],
 * // [1,1,1],
 * // [0,1,1]]
 * //输出: 1
 * //说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * //
 * //
 * // 注意：
 * //
 * //
 * // N 在[1,200]的范围内。
 * // 对于所有学生，有M[i][i] = 1。
 * // 如果有M[i][j] = 1，则有M[j][i] = 1。
 * //
 * // Related Topics 深度优先搜索 并查集
 *
 * @author : Administrator
 * @date : 2020/5/2
 */
public class FindCircleNum {

    public int findCircleNum1(int[][] M) {
        if (null == M) {
            return 0;
        }
        int personNum = M.length;
        if (personNum == 0) {
            return 0;
        }
        DisjointSet disjointSet = new DisjointSet(personNum);
        for (int i = 0; i < personNum; i++) {
            for (int j = 0; j < personNum; j++) {
                if (M[i][j] == 1) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.getCount();
    }

    /**
     * 深度优先搜索
     *
     * @param M
     * @return
     */
    public int findCircleNum2(int[][] M) {
        if (null == M) {
            return 0;
        }
        int personNum = M.length;
        if (personNum == 0) {
            return 0;
        }
        boolean[] marked = new boolean[personNum];
        int count = 0;
        for (int i = 0; i < personNum; i++) {
            if (!marked[i]) {
                search(M, i, marked);
                count++;
            }
        }
        return count;
    }

    private void search(int[][] m, int i, boolean[] marked) {
        marked[i] = true;
        for (int j = 0; j < m.length; j++) {
            if (!marked[j] && m[i][j] == 1) {
                search(m, j, marked);
            }
        }
    }


    public class DisjointSet {

        private int count = 0;
        private int[] parent;

        public DisjointSet(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
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
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int getCount() {
            return count;
        }
    }

}
