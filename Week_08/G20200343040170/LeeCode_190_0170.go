func reverseBits(num uint32) uint32 {
    ret := uint32(0)
    for i := 0; i < 32; i++ {
        ret = (ret << 1) + (num & 1)
        num = num >> 1
    }
    return ret
}

func reverseBits2(num uint32) uint32 {
    ret := uint32(0)
    power := uint32(31)
    for num != 0 {
        ret += (num & 1) << power
        num = num >> 1
        power--
    }
    return ret
}