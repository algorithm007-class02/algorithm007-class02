func hammingWeight(num uint32) int {
    bits := 0
    for num != 0 {
        num = num & (num -1)
        bits++
    }
    return bits
}

func hammingWeight2(num uint32) int {
    bits := 0
    mask := uint32(1)
    for i := 0; i < 32; i++ {
        if num & mask != 0 {
            bits++
        }
        mask = mask << 1
    }
    return bits
}