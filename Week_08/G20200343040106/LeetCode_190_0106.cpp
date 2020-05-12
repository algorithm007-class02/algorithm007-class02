class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        
        for(int i=0;i<16;i++) {
            uint32_t l = n&(1<<(32-i-1));
            uint32_t r = n&(1<<i);
            if((l&&r)||(!l&&!r)) continue;
            if(l&&!r) {
                n -= (1<<(32-i-1));
                n += (1<<i);
            } else {
                n += (1<<(32-i-1));
                n -= (1<<i);
            }
        }
        return n;
    }
};