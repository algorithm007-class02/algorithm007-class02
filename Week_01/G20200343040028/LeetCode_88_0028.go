package G20200343040028


func merge(nums1 []int, m int, nums2 []int, n int)  {
	if m == 0 {
		copy(nums1, nums2)
		return
	}
	if n == 0 {
		return
	}
	length := m + n
	for ; m > 0 && n > 0; length--{
		if nums1[m-1] > nums2[n-1] {
			nums1[length-1]= nums1[m-1]
			m--
		} else {
			nums1[length-1] = nums2[n-1]
			n--
		}

	}
	for ; n > 0; length--{
		nums1[length-1] = nums2[n-1]
		n--

	}
}