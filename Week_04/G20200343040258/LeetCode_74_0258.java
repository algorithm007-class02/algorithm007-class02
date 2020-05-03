class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分
        //先从每行的头元素进行比较 找到 大于pre 并且小于 suf的，就pre进入查询遍历
        if( matrix == null)
        return false;
        int sartRow = -1;
        int rowLen = matrix.length;
        if(rowLen == 1){
            sartRow = 0;
        }else{
            for(int i = 0; i < rowLen - 1; i++){
                if(target == matrix[i][0] || target == matrix[i + 1][0]){
                    return true;
                }
                if(target > matrix[i][0] && target < matrix[i + 1][0]){
                    sartRow = i;
                    break;
                }

                if(i == rowLen - 2){
                    sartRow = i + 1;
                }
             }
        }
      
        if(sartRow != -1){
            int len = matrix[sartRow].length;
            for(int i = 0; i < len; i++){
                if(matrix[sartRow][i] == target){
                    return true;
                }
                if(target < matrix[sartRow][i]){
                    return false;
                }
            }
        }
        return false;
    }
}