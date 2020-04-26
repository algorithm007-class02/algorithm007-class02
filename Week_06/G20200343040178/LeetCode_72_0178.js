/*
 * @Author: mingxing.huang
 * @Date: 2020-04-18 17:03:30
 */
/**
 * 编辑距离
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function (word1, word2) {
    /**
     * dp(i, j)：以下标i、j结尾的字符串的最少操作次数
     * 如果word1[i] === word2[j]，i和j都往前走一步，继续比
     * 如果word1[i] !== word2[j]，插入、删除、替换三选一
     *  插入：在i后面插入一个word2[j]，i不变，j往前，次数+1
     *  删除：删除word1[i]，i往前，j不变，次数+1
     *  替换：将word1[i]替换成word2[j]，i、j都往前，次数+1
     * 记忆化搜索，避免重复计算
     */
    let i = word1.length - 1;
    let j = word2.length - 1;
    let memo = {};
    return dp(i, j);
    function dp(i, j) {
        const key = i + '-' + j;
        if (memo[key]) return memo[key];
        // 终止条件，有一方比较完了，将另一个字符串剩下的做删除操作
        if (i === -1) return j + 1;
        if (j === -1) return i + 1;
        if (word1[i] === word2[j]) {
            memo[key] = dp(i - 1, j - 1);
        } else {
            memo[key] = Math.min(dp(i, j - 1) + 1, dp(i - 1, j) + 1, dp(i - 1, j - 1) + 1);
        }
        return memo[key];
    }
}