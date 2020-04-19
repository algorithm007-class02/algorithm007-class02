//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=126 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 */
class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return String[][]
     */
    function findLadders($beginWord, $endWord, $wordList) {
		$ans = $paths = [];
        $wordList = array_flip($wordList);
        $paths[] = [$beginWord];
        $level = 0;
        $min_level = pow(2, 31);
        $visited = [];
        while (!empty($paths)) {
            $path = array_shift($paths);
            if (count($path) > $level) {
                foreach ($visited as $w=>$i) unset($wordList[$w]);
                $visited = [];
                if (count($path) > $min_level) break;
                $level = count($path);
            }
            $last = end($path);
            for ($i = 0; $i < strlen($last); $i++) {
                $news = $last;
                for ($k = ord('a'); $k <= ord('z'); $k++) {
                    $news[$i] = chr($k);
                    if (isset($wordList[$news])) {
                        $newpath = $path;
                        $newpath[] = $news;
                        $visited[$news] = true;
                        if ($news == $endWord) {
                            $min_level = $level;
                            $ans[] = $newpath;
                        } else {
                            $paths[] = $newpath;
                        }
                    }
                }
            }
        }
        return $ans;
    }
}
// @lc code=end
