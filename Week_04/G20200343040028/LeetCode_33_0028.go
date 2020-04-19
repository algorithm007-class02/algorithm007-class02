package G20200343040028
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	var  findMiddle = func(nums []int,target int)int{
		var start,end = 0,len(nums)-1
		var mid = 0
		for start < end{
			mid = start + (end-start)/2
			if mid == start{
				return mid
			}
			if nums[mid] > nums[end]{
				start = mid
				continue
			}else{
				end = mid
			}
		}

		return end
	}

	var start,end = 0,len(nums)-1
	var mid = findMiddle(nums,target)

	if nums[mid] == target{
		return mid
	}

	if nums[end] < target{
		end = mid
	}else {
		start = mid
	}

	for start <= end{
		mid = start + (end-start)/2
		if nums[mid] == target{
			return mid
		}

		if mid == start{
			if nums[end] == target{
				return end
			}

			break
		}

		if nums[mid] > target{
			end = mid
			continue
		}else{
			start = mid
		}
	}

	return -1
}

