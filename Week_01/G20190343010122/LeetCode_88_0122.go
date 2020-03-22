/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package homework

func merge(nums1 []int, m int, nums2 []int, n int){
	if n == 0{
		return
	}

	// 双下标法
	hIndex := m+n-1  // 指向目标数组的最高索引处
	mIndex := m-1
	nIndex := n-1

	for ; (mIndex >=0) && (nIndex>=0);  {
		if nums1[mIndex]> nums2[nIndex]{
			nums1[hIndex] = nums1[mIndex]
			mIndex--
		}else {
			nums1[hIndex] = nums2[nIndex]
			nIndex--
		}
		hIndex--
	}

	// nums2 可能还剩下一些更小的数没有合并进Nums1
	for i:=nIndex; i>=0 ; i-- {
		nums1[hIndex] = nums2[i]
		hIndex--
	}
}

