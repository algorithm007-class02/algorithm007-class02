// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

// 示例 1:
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]

// 第一种自写解法
// func rotate(nums []int, k int)  {
//     for a:=0; a < k; a++ {
//         key := len(nums) - 1
//         d := nums[key]
//         j := key
//         for i := (key - 1);  i >= 0;i-- {
//             nums[j] = nums[i]
//             j--
//         }
//         nums[0] = d
//     }
// }

// 学习后优化解法
func rotate(nums []int, k int)  {
    for a:=0; a < k; a++ {
        key := len(nums) - 1
        d := nums[key]
        j := key
        for i := (key - 1);  i >= 0;i-- {
            nums[j] = nums[i]
            j--
        }
        nums[0] = d
    }
}