//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=127 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * 双bfs
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList) {
        $wordList = array_flip($wordList);
        if (!isset($wordList[$endWord])) return 0;
        $queue1 = [$beginWord];
        $queue2 = [$endWord];
        $n = strlen($beginWord);
        $step = 0;
        while($queue1) {
            if (count($queue1) > count($queue2)) [$queue1, $queue2] = [$queue2, $queue1];
            $step++;
            $size = count($queue1);
            $h2 = array_flip($queue2);
            while ($size--) {
                $word = array_shift($queue1);
                for($i = 0; $i < $n; $i++) {
                    $old = $word[$i];
                    for ($k = ord('a'); $k <= ord('z'); $k++) {
                        if ($old == chr($k)) continue;
                        $word[$i] = chr($k);
                        if (isset($h2[$word])) return $step + 1;
                        if (isset($wordList[$word])) {
                            unset($wordList[$word]);
                            $queue1[] = $word;
                        }
                    }
                    $word[$i] = $old;
                }
            }
        }
        return 0;
    }
}
// @lc code=end
