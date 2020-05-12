package homework

func reverseBits(num uint32) uint32 {
	ans := uint32(0)
	for i:=0; i<32; i++{
		ans = (ans<<1) + (num&1)
		num >>= 1
	}
	return ans;
}
