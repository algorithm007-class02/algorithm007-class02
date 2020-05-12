class Solution {
public:
    int hammingWeight(uint32_t n) {
        long sum = 0;
        while(n) {
            sum++;
            n = n & (n - 1);
        }

        return sum;
    }
};