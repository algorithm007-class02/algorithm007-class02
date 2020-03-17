// 时间复杂度：O(n)，空间复杂度：O(n)
class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		// 哈希表存贮
		unordered_map<int, int> temp;
		for (int i = 0; i < nums.size(); i++) {
			if (temp.count(target - nums[i])) {
				return {temp[target - nums[i]], i};
			} else {
				temp[nums[i]] = i;
			}
		}
		return {0,0};
	}
};