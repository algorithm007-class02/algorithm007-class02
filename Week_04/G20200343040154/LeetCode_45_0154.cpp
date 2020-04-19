// 45. 跳跃游戏 II
// https://leetcode-cn.com/problems/jump-game-ii/

// 解法：贪心算法
// 因为题目明确必然能走到最后一格，所以只需要最大化每一步的步福即可。步福==nums[i]+i.
class Solution {
public:
	int jump(vector<int>& nums) {
		int step=0, maxPos=0, end=0;
		for (int i=0; i<nums.size()-1; i++) {
			maxPos = max(nums[i]+i, maxPos);
			if (i == end) {
				end = maxPos;
				step++;
			}
		}
		return step;
	}
};