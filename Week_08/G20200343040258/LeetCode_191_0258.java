class Solution {
    //并查集
    private class UnionFind{
        private int count;
        private int[] parent;
        //初始化
        public UnionFind(int n){
            count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        //找到领头羊
        public int findParent(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        //合并朋友圈
        public void union(int p,int q){
            int topP = findParent(p);
            int topQ = findParent(q);
            if(topP == topQ) return;
            parent[topP] = topQ;
            count--; 
        }

        public int count(){
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        //自己和自己肯定是朋友 所以j 和 i 不需要重复
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(M[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count;
    }
}