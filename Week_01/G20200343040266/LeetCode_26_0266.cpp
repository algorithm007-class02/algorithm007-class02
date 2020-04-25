class Solution {
public:
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() <= 1) return nums.size();
		int slow = 0, fast = 1;
		for (; fast < nums.size(); fast++) {
			if (nums[fast] != nums[slow]) {
				nums[++slow] = nums[fast];
			}
		}
		return slow + 1;
	}
};