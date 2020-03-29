// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 示例:
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]

func moveZeroes(nums []int)  {
    j := 0
    for i := 0; i < len(nums);i++ {
        if nums[i] != 0 {
            nums[j] = nums[i]
            j++
        }
    }
    for i := j; i < len(nums);i++ {
        nums[i] = 0
    }
}