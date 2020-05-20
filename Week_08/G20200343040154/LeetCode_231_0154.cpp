// 231. 2的幂
// https://leetcode-cn.com/problems/power-of-two/

class Solution {
public:
	bool isPowerOfTwo(int n) {
		// 要写成(n&(n-1))==0而不能是n&(n-1)==0，运算符的优先级也要注意
		return (n > 0) && ((n & (n-1)) == 0);
	}
};