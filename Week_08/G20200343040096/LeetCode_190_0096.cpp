class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        const int size = 32;
        uint32_t res = 0;
        for(int i = 0; i < 32; ++i){
            res = res << 1;
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }
};
