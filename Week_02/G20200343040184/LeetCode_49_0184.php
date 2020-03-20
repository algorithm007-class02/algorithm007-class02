//<?php
/**
 * @lc app=leetcode.cn id=49 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */
class Solution {

    /**
     * 方法一：字母计数分类
     * 主要设计一个合理的哈希算法
     * 时间复杂度：O(NK)O(NK)
     * 空间复杂度：O(NK)O(NK)
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams1($strs) {
        $map = [];
        for ($i = 0, $count = count($strs); $i < $count; $i++) {
            //计算生成key
            $keys = count_chars($strs[$i]);
            $key = "";
            foreach($keys as $k=>$v){
                $key .= "{$k},{$v}#";
            }
            $map[$key][] = $strs[$i];
        }
        return array_values($map);
    }
    /**
     * 方法二：字母排序分类
     * 主要设计一个合理的哈希算法
     * 时间复杂度 O(NKlog(K)), N为数组长度，M为单字符串最长长度。
     * 空间复杂度 O(NK)
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $map = [];
        for ($i = 0, $count = count($strs); $i < $count; $i++) {
            //计算生成key
            $keys = str_split($strs[$i]);
            sort($keys);
            $key = implode($keys);
            $map[$key][] = $strs[$i];
        }
        return array_values($map);
    }
}
// @lc code=end