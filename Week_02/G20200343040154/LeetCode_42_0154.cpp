// 解法：双指针法
// 处理：两边夹逼，每向中间靠拢一步，就计算出当前步贡献值，进行累加
class Solution {
public:
	int trap(vector<int>& height) {
		int total = 0;
		int size = height.size();
		if (size == 0) return total;
		int left = 0;
		int right = size - 1;
		int maxLeft = height[0];
		int maxRight = height[size-1];

		while(left <= right) {
			maxLeft = max(height[left], maxLeft);
			maxRight = max(height[right], maxRight);
			if (maxLeft < maxRight) {
				total += maxLeft - height[left];
				++left;
			} else {
				total += maxRight - height[right];
				--right;
			}
		}
		return total;
	}
};
