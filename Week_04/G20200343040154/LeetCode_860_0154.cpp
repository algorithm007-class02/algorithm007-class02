
// 860. 柠檬水找零
// https://leetcode-cn.com/problems/lemonade-change/

// 解法1：贪心算法
// 从小到大不停贪心
//Time O(N)
//Space O(1)

class Solution {
public:
	bool lemonadeChange(vector<int>& bills) {
		int num5=0, num10=0;
		for (auto b : bills) {
			if (b == 5) {
				++num5;
			} else if (b == 10) {
				if (num5 > 0) {
					--num5;
					++num10;
				} else {
					return false;
				}
			} else {
				if (num5 > 0 && num10 > 0) {
					--num5;
					--num10;
				} else if (num5 >= 3) {
					num5 = num5-3;
				} else {
					return false;
				}
			}
		}
		return true;
	}
};

// 解法2:贪心算法
class Solution {
public:
	bool lemonadeChange(vector<int>& bills) {
		int five=0, ten=0;
		for (auto i: bills) {
			if (i==5) ++five;
			else if (i==10) five--,ten++;
			else if (ten>0) five--,ten--;
			else five -= 3;
			if (five<0) return false;
		}
		return true;
	}
};

