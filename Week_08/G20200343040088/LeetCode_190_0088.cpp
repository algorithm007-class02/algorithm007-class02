class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ret;
        for (int i = 0; i < 32; i++) {
            ret = n % 2 + ret * 2;
            n = n / 2;
        }
        return ret;
    }
};