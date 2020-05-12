//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {
    /*练手3，二分法*/
    public int mySqrt(int x){
        long left = 0;
        long right = x/2+1;
        while (left<right){
            long rightmid = left+(right-left+1)/2;
            long square = rightmid*rightmid;
            if (square>x){
                right=rightmid-1;
            } else {
                left=rightmid;
            }
        }
        return (int)left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*练手2*/
//    public int mySqrt(int x){
//        long left = 0;
//        long right = x/2+1;
//        while (left<right){
//            long rightmid = left+(right-left+1)/2;
//            long square = rightmid*rightmid;
//            if (square>x){
//                right=rightmid-1;
//            } else {
//                left=rightmid;
//            }
//        }
//        return (int)left;
//    }

/*练手1*/
//    public int mySqrt(int x){
//        long left = 0;
//        long right = x/2+1;
//        while (left<right){
//            long rightmid = (left+right+1)>>>1;
//            long square = rightmid*rightmid;
//            if (square>x){
//                right=rightmid-1;
//            } else {
//                left = rightmid;
//            }
//        }
//        return (int)left;
//    }

//    public int mySqrt(int x) {
//        //为了针对特殊用例，把搜索范围设置成长整形
//        //  为了照顾到0，将左边界设置为0
//        long left = 0;
//        long right = x/2+1;
//        while (left<right){
//            //要取右中位数，左中位数会让代码进入死循环
//            //左中位数：long leftmid = left+（right-left+1）>>>1;
//            //右中位数↓ long rightmid = left + (right - left +1)/2;
//            long rightmid = (left+right+1)>>> 1;
//            long square = rightmid*rightmid;
//            if (square>x){
//                right=rightmid-1;
//            } else {
//                left = rightmid;
//            }
//        }
//        return (int) left;
//    }
//    /*
//     * 耗时0ms（100%），使用内存37.1M（6%）*/