//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int p2 =0,p3 = 0,p5 = 0;
        int[] result = new int[n];
        result[0] = 1;
        for ( int i = 1; i < n; i++ ) {
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if (result[i] == result[p2]*2) p2++;
            if (result[i] == result[p3]*3) p3++;
            if (result[i] == result[p5]*5) p5++;
        }
        return result[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
