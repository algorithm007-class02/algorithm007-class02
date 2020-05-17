/*
����1
ʱ�临�Ӷȣ�O(1)
�ռ临�Ӷȣ�O(1)
*/
class Solution {
public:
	int hammingWeight(uint32_t n) {
		int bits = 0;
		while (n) {
			bits++;
			n &= n - 1;
		}
		return bits;
	}
};
/*
����2
ʱ�临�Ӷȣ�O(1)
�ռ临�Ӷȣ�O(1)
*/
class Solution {
public:
	int hammingWeight(uint32_t n) {
		int bits = 0;
		uint32_t mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) > 0)
				bits++;
			mask = mask << 1;
		}
		return bits;
	}
};
/*
����3
ʱ�临�Ӷȣ�O(1)
�ռ临�Ӷȣ�O(1)
*/
class Solution {
public:
	int hammingWeight(uint32_t n) {
		int count = 0;
		while (n > 0) {
			if (n & 0x1)
				count++;
			n = n >> 1;
		}
		return count;
	}
};