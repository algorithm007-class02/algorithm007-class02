// 解法 1:
// 时间复杂度：O(n)，空间复杂度：O(1)
class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		int j = 0;  // 保存非0的值
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				if (j != i) {
					nums[i] = 0;
				}
				j++;
			}
		}
	}
};

// 解法 2:
// 时间复杂度：O(n)，空间复杂度：O(1)
class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		int j = 0; // 保存非0的值
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] != 0) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
	}
};