// 191. 位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/

class Solution {
public:
	int hammingWeight(uint32_t n) {
		int count = 0;
		while(n != 0) {
			n = n & (n-1);
			count++;
		}
		return count;
	}
};