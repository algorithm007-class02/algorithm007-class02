package G20200343040028
/**
1. dp[i]表示以i下标 数值 为子序列结束时最长上升子序列的长度 初始时默认为1
2. 递推式为 dp[i] = max(dp[i],dp[j]+1) for j in 0 to i,其含义为:
   以nums[i]为结束的最长上升子序列是之前所有子序列中最长上升子序列长度+1的最大值
3. 最终的结果是dp数组中最大的一个值,其含义为
   一个数组的最长上升子序列的长度是其以任意一个元素为序列结束位置的长度最大值
*/

func lengthOfLIS(nums []int) int {
	if len(nums) == 0{
		return  0
	}
	dp, res := make([]int,len(nums)), 0
	for i:=0; i<len(dp); i++{
		dp[i]=1
	}
	for i:=0; i<len(nums); i++{
		for j:=0; j<i; j++{
			if nums[i] > nums[j]{
				dp[i] = max(dp[i],dp[j]+1)
			}
		}
		res = max(res,dp[i])
	}
	return res
}
func max(a, b int)int{
	if a > b{
		return a
	}
	return b
}