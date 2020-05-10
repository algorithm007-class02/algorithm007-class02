//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=1122 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * 方法一
     * @param Integer[] $arr1
     * @param Integer[] $arr2
     * @return Integer[]
     */
    function relativeSortArray1($arr1, $arr2) {
        $arr = array_fill(0, 1001, 0);
        foreach ($arr1 as $num) {
            $arr[$num]++;
        }
        $res = [];
        foreach ($arr2 as $num) {
            while ($arr[$num]) {
                $res[] = $num;
                $arr[$num]--;
            }
        }
        for ($i = 0; $i <= 1001; $i++) {
            while ($arr[$i]) {
                $res[] = $i;
                $arr[$i]--;
            }
        }
        return $res;
    }

    //方法二
    function relativeSortArray($arr1, $arr2) {
        $arr = array_count_values($arr1);
        $res = [];
        foreach ($arr2 as $num) {
            while ($arr[$num]) {
                $res[] = $num;
                $arr[$num]--;
            }
            unset($arr[$num]);
        }
        ksort($arr);
        foreach ($arr as $num => $count) {
            while ($count) {
                $res[] = $num;
                $count--;
            }
        }
        return $res;
    }
}
// @lc code=end
