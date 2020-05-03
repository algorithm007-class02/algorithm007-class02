//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=433 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * 
 * 注意:
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 
 * 示例 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 返回值: 1
 * 
 * 示例 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 返回值: 2
 * 
 * 示例 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 返回值: 3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * 双bfs
     * @param String $start
     * @param String $end
     * @param String[] $bank
     * @return Integer
     */
    function minMutation($start, $end, $bank) {
        $bank = array_flip($bank);
        if (!isset($bank[$end])) return -1;
        if ($start == $end) return 0;
        $q1 = [$start];
        $q2 = [$end];
        $len = strlen($start);
        $chars = ['A', 'C', 'G', 'T'];
        $step = 0;
        while ($q1) {
            $step++;
            if (count($q1) > count($q2)) [$q1, $q2] = [$q2, $q1];
            $size  = count($q1);
            $h2 = array_flip($q2);
            while ($size--) {
                $word = array_shift($q1);
                for ($i = 0; $i < $len; $i++) {
                    $old = $word[$i];
                    foreach ($chars as $char) {
                        $word[$i] = $char;
                        if (isset($h2[$word])) return $step;
                        if (isset($bank[$word])) {
                            unset($bank[$word]);
                            $q1[] = $word;
                        }
                    }
                    $word[$i] = $old;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
