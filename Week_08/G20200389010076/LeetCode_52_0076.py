#
# @lc app=leetcode.cn id=52 lang=python3
#
# [52] N皇后 II
#

# @lc code=start
class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count=0
        def dp(row,col,pie,na):
            if row==n:
                self.count+=1
                return
            
            pmt=(~(col|pie|na))&((1<<n)-1)

            while pmt!=0:
                #取空位
                p=pmt&(-pmt)
                dp(row+1,col|p,(pie|p)<<1,(na|p)>>1)
                pmt=pmt&(~p)
        
        dp(0,0,0,0)
        return self.count
                
# @lc code=end

