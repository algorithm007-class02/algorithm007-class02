import java.util.Arrays;

class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent,-1);
        for(int i = 0;i < M.length;i++){
            for(int j = 0;j < M.length;j++){
                if(M[i][j] == 1 && i != j){
                    union(parent,i,j);
                }
            }
        }
        int count = 0;
        for(int i = 0;i < parent.length;i++){
            if(parent[i] == -1){
                count++;
            }
        }
        return count;
    }

    //联合
    private void union(int[] parent,int i,int j){
        int xx = find(parent,i);
        int yy = find(parent,j);
        if(xx != yy){
            parent[xx] = yy;
        }
    }

    //寻找
    private int find(int[] parent,int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent,parent[i]);
    }
}