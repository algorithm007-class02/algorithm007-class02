/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
    //题意：数据大于0 且有且仅有一位1，才可以满足该数字是2的幂次
    //1.位运算：获取二进制中最右边的 1
    // x & (-x) 可以获取到二进制中最右边的 1，且其它位设置为 0。
    // 在补码表示法中，−x=¬x+1-x 。换句话说，要计算 −x，则要将 x所有位取反再加 1。
    // 因此，x 和−x 只有一个共同点：最右边的 1。这说明 x & (-x) 将保留最右边的 1。并将其他的位设置为 0。
    //因为只有一位1，所以x&-x==下成立才可以满足2的幂次。
        // if (n == 0) {
        //     return false;
        // }
        // long x =(long)n;
        // return (x & (-x)) == x;
        
    
    //2.位运算：去除二进制中最右边的 1
    // x & (x - 1) 可以将最右边的 1 设置为 0。
    // 2 的幂二进制表示只含有一个 1。
    // x & (x - 1)  操作会将 2 的幂设置为 0，因此判断是否为 2 的幂是：判断 x & (x - 1) == 0。
        if (n == 0) {
            return false;
        }
        long x =(long)n;
        return  (x & (x-1)) == 0;
    }
}
// @lc code=end

