//斐波那契数，通常用 F(N) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
/** right clean code*/
class Solution509 {

    /**自底向上的方法,速い */
    public int fib(int N){
        if (N<=1) {return N;}

        int[] ans = new int[N+1];
        ans[0]=0;
        ans[1]=1;
        for (int i=2; i<=N; i++){
            ans[i]=ans[i-1]+ans[i-2];
        }

        return ans[N];
    }
    /*
     * 耗时0ms（100%），使用内存36.9M（5%）*/
}
//leetcode submit region end(Prohibit modification and deletion)

/**优化后
 * 时间复杂度为O(n)的解决方法
 * LeetCode不能测试
 * 自顶向下的方法
 * 也是所谓的"分治"的算法*/
//    public int fib(int N, int[] memo){
//        if (N<=1) {return N;}
//        if (memo[N]==0){
//            memo[N]=fib(N-1,memo)+fib(N-2,memo);
//        }
//        return memo[N];
//    }

/**简洁表达法*/
//    public int fib(int N){
//        return N<=1 ? N: fib(N-1)+fib(N-2);
//    }
/*
 * 耗时9ms（28%），使用内存36.4M（5%）*/

//    /**传统递归法，果然够慢
//    指数级节点个代码*/
//    public int fib(int N) {
//        if (N<=0){
//            return 0;
//        } else if (N==1){
//            return 1;
//        } else {
//            return fib(N-1)+fib(N-2);
//        }
//    }
//    /* 时间复杂度是指数级的,O(2^N)
//     * 耗时18ms（5%），使用内存35.9M（5%）*/