//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution221 {
    /*暴力练手2*/
    public int maximalSquare(char[][] matrix){
        int maxSide=0;
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {return maxSide;}
        int row = matrix.length;
        int col= matrix[0].length;

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (matrix[i][j]=='1'){
                    maxSide = Math.max(maxSide,1);
                    int curentMaxSide = Math.min(row-i,col-j);
                    for (int k=1; k<curentMaxSide; k++){
                        boolean flag = true;
                        if (matrix[i+k][j+k]=='0'){
                            break;
                        }
                        for (int m=0; m<k; m++){
                            if (matrix[i+m][j+k]=='0' || matrix[i+k][j+m]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if (flag){
                            maxSide=Math.max(maxSide,k+1);
                        } else {break;}
                    }
                }
            }
        }
        int maxS = maxSide*maxSide;
        return maxS;
    }
    /*
     * 耗时5ms（94%），使用内存43.2M（25%）*/
}
//leetcode submit region end(Prohibit modification and deletion)

/*暴力练手1*/
//    public int maximalSquare(char[][] matrix){
//        int maxSide=0;
//        if (matrix==null || matrix.length==0 || matrix[0].length==0) {return maxSide;}
//        int row = matrix.length;
//        int col = matrix[0].length;
//
//        for (int i=0; i<row; i++){
//            for (int j=0; j<col; j++){
//                if (matrix[i][j]=='1'){  //这里没有注意到
//                    maxSide=Math.max(maxSide,1);
//                    int currentMaxSide = Math.min(row-i,col-j);
//
//                    for (int k=1; k<currentMaxSide; k++){
//                        boolean flag = true;
//                        if (matrix[i+k][j+k]=='0') {break;}
//                        for (int m=0; m<k; m++){
//                            if (matrix[i+m][j+k]=='0' || matrix[i+k][j+m]=='0'){
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if (flag){
//                            maxSide=Math.max(maxSide,k+1);
//                        } else {break;}  //这里的break没有注意到
//                    }
//                }
//            }
//        }
//        int maxS = maxSide*maxSide;
//        return maxS;
//    }
/*
 * 耗时5ms（94%），使用内存43.2M（25%）*/

/*暴力法*/
//    public int maximalSquare(char[][] matrix) {
//
//        int maxSide=0;
//        if (matrix==null || matrix.length==0 || matrix[0].length==0) {return maxSide;}
//        int row = matrix.length;
//        int col = matrix[0].length;
//
//        for (int i=0; i<row; i++){
//            for (int j=0; j<col; j++){
//                //遇到1，则作为正方形的左上角
//                if (matrix[i][j]=='1'){
//                    // 最大边长最小为1
//                    maxSide=Math.max(maxSide,1);
//                    //计算可能的最大边长---到两边边界的距离的较小值
//                    int currentMaxSide = Math.min(row-i,col-j);
//
//                    //开始"试探",先判断对角线，然后再分别查看对角线两侧的位置，学习这个遍历方式
//                    for (int k=1; k<currentMaxSide; k++){
//                        //此处flag的作用是，让拥有m的循环在break之后，不去更新maxSide
//                        boolean flag = true;
//                        if (matrix[i+k][j+k]=='0') {
//                            //这里不将flag设置为false是因为，现在只是在试探，有可能一部分对角线上的元素为1，一部分为0
//                            //跳出时matrix[i+k][j+k]（一旦开始为0就舍弃其余的部分）
//                            break;
//                        }
//                        for (int m=0; m<k; m++){
//                            //从上到下，从左到右，每次交汇于matrix[i+k][j+k]
//                            //先判断对角线位置是否为1，再验证交界点上面和左面的元素们，好方法
//                            if (matrix[i+m][j+k]=='0' || matrix[i+k][j+m]=='0'){
//                                flag=false;
//                                break;
//                            }
//                        }
//                        if (flag){
//                            //终于看明白为什么这里是k+1了，当m的循环检查完后发现可以构成正方形时（有可能未来最大边长还会扩大）
//                            //这时候需要加上左上角起始元素的1个长度
//                            //如果k更新后matrix[i+k][j+k]=='0'，就会直接跳出大循环，那时候的k也就不用+1
//                            maxSide=Math.max(maxSide,k+1);
//                        } else {break;}
//                    }
//                }
//            }
//        }
//        int maxS = maxSide*maxSide;
//        return maxS;
//    }
/*
 * 耗时6ms（87%），使用内存43.3M（25%）*/
