// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
// 你可以假设除了整数 0 之外，这个整数不会以零开头。

// 示例 1:
// 输入: [1,2,3]
// 输出: [1,2,4]
// 解释: 输入数组表示数字 123。

func plusOne(digits []int) []int {
    l := len(digits) - 1
    for i := l; i >= 0; i-- {
        if digits[i] == 9 {
            digits[i] = 0
        } else {
            digits[i] += 1
            return digits
        }
    }
    return append([]int{1},digits...)
}