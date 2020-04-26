//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int r=0; r<row; r++){
            for (int c=0; c<col; c++){
                if (matrix[r][c]==0){
                    queue.offer(new int[] {r,c});
                } else {
                    //-1为未访问过的标志
                    matrix[r][c]=-1;
                }
            }
        }

        //巧妙的顺序
        int[] horizon = {-1,1,0,0};
        int[] vertical = {0,0,-1,1};

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            //x,y是每一处0所在的下标
            int x = temp[0];
            int y = temp[1];
            for (int i=0; i<4; i++){
                int newX = x+horizon[i];
                int newY = y+vertical[i];
                if (newX>=0 && newX<row && newY>=0 && newY<col && matrix[newX][newY]==-1){
                    //注意，前后下标，当[newX][newY]值为-1时，记录偏差量（即距离）
                    //这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                    matrix[newX][newY]=matrix[x][y]+1;
                    //有了if条件，还要加入{newX,newY},大概是为了
                    queue.offer(new int[] {newX,newY});
                }
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
