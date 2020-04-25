package homework

import (
	"testing"
)

func Test_merge(t *testing.T){
/*输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/

	nums1 := []int{1,2,3,0,0,0}
	nums2 := []int{2,5,6}
	output := []int{1,2,2,3,5,6}
	merge(nums1, 3, nums2, 3)
	for i:=0; i<len(nums1) ; i++{
		if nums1[i] != output[i]{
			t.Fail()
		}
	}
}
