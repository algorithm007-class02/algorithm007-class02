<?php
// NO.49 字母异位分组
class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $map = [];
        foreach ($strs as $str) {
            $arr = str_split($str);
            sort($arr);
            $tmp_str = implode("", $arr);
            $map[$tmp_str][] = $str;
        }
        return array_values($map);
    }

}