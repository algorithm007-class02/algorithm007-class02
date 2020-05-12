/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

class Solution {
	List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n < 1){
            return res;
        }
        List<Integer> list = new ArrayList<>();

        help(0,n,list);
        return res;
    }
    private void help(int row, int n, List<Integer> list){
        if(row == n){
            List<String> strList = new ArrayList<>();
            for(Integer num:list){
                char[] t = new char[n];
                Arrays.fill(t,'.');
                t[num] = 'Q';
                strList.add(new String(t));
            }
            res.add(strList);
            return;

        }
        //每一列都尝试一下
        for (int col = 0; col < n; col++) {
            //当前列是否合法
            if (!list.contains(col)) {
                //左斜与右协是否合法
                if(!isDiagonalAttack(list,col)){
                    list.add(col);
                    help(row+1,n,list);
                    //回溯
                    list.remove(list.size()-1);
                }
            }

        }

    }

    //(a,b) (i,j)两个点，如果abs(a-i)==abs(b-j) 那么两点就在同一斜线上，应该是这个意思吧
    private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
        int currentRow = currentQueen.size();
        int currentCol = i;
        //判断每一行的皇后的情况
        for (int row = 0; row < currentQueen.size(); row++) {
            //左上角的对角线和右上角的对角线，要么相等，要么互为相反数，直接写成了绝对值
            if (Math.abs(currentRow - row) == Math.abs(currentCol - currentQueen.get(row))) {
                return true;
            }
        }
        return false;
    }
}

// @lc code=end

