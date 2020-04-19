package homework

func canJump(nums []int) bool {
	numsSize := len(nums)
	if numsSize == 0{
		return false
	}

	canReachable := numsSize-1
	for i:=canReachable; i>=0; i-- {
		if nums[i]+i >= canReachable{
			canReachable = i
		}
	}

	return canReachable == 0
}
