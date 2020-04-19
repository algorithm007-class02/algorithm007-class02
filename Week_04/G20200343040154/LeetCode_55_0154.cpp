// 55. 跳跃游戏
// https://leetcode-cn.com/problems/jump-game/

// // 解法1:贪心-从左到右
// class Solution {
// public:
//     bool canJump(vector<int>& nums) {
//         int right = 0;
//         for (int i = 0; i<nums.size(); i++) {
//             if (right < i) return false;
//             right = max(right, nums[i]+i);
//         }
//         return true;
//     }
// };

// 解法2:贪心-从右到左
class Solution {
public:
	bool canJump(vector<int>& nums) {
		int left = nums.size()-1;
		for (int i = nums.size()-1; i>=0; i--) {
			if (nums[i]+i >= left) {
				left = i;
			}
		}
		return left == 0;
	}
};


