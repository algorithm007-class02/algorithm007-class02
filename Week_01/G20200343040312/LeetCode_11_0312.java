//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
/*
* 查看解答前的思考：
*   1. 最笨的方法，暴力计算每两条“高度线”之间的面积
*       根据“木桶理论”，先将最低的高度比较出来
*       然后S=（低）*|(i-j)|
*       由化简公式得出只需要控制两个下标即可。
    *       a.将结果存入新数组后排序后返回，sort()默认升序但其返回值为void，需要手动写排序
    *           而使用（j=i+1）时，开辟的用于存放结果的新数组长度应为（(height.length*（height.length-1）/2)+1）
    *              +1是为了防止整数除以2后出现的问题
    *       b.每次出来两个结果后仅保留较大的那个，最后返回
*       选b
*       另外还要注意，j==i，因为这会导致公式与实际情况不符
*       暴力双循环遍历（内循环j=i）肯定是有重复的，使用（j=i+1）能够避免重复计算，但时间复杂度的量级没有改变，为O(n^2)
*   2.短时间内没有想到其他好的方法
* */

/*
* 查看解答后的思考：
*   1. 哈哈，超哥题到了j=i+1的遍历优化
*       另外，学习超哥的饭吗，对方法一进行了优化
*           a.直接使用Math.min()得出较小值（自己都用了Math.abs()了，竟然不用min()...）
*           b.对于循环的变量，直接在循环中进行声明，能使得代码简洁美观
*           c.内循环使用j=i+1;外循环i的限制可以使用i<height.length-1，因为j是i后面一个
*               i“最后”到height.length-2即可遍历全部
*   2. 方法二
*       “从两边想中间收拢”---即，由于公式S=（低）*|(i-j)|可得，我们可以先将宽度尽可能得固定到最大
*       然后移动原来两端中较小的一条边
*       最后有两种比较法
*           a.直接计算面积，取更大的存入maxS中
*           b.在收缩时将每次收缩后的（低收）与原来最两端的（低原）进行比较，（低收）<（低原）
    *       那么不用计算便可得知这次收缩后的面积小，比最两端时的要小。
    *       如果高，那么比较、计算。---###这里的比较是有窍门的---“谁更小谁就挪”
    *   选择a.更为简洁
*       由于没有嵌套，因此该犯法时间复杂度为O(n)
*       ###方法二中的循环写法要着重掌握
* */

class Solution11 {
    public int maxArea(int[] height) {

        /*
        * 方法一*/
//        int i,j=0;
//        int S,maxS=0;
//
//        for (i=0; i<height.length; i++){
//            //使用j=i+1，减少次数
//            for (j=i+1; j<height.length; j++){
//                if (height[j]>height[i]){
//                    S=height[i]*Math.abs(i-j);
//                    if (S>maxS){
//                        maxS=S;
//                    }
//                }else{
//                    S=height[j]*Math.abs(i-j);
//                    if (S>maxS){
//                        maxS=S;
//                    }
//                }
//            }
//        }
//        return maxS;
        /*
         * 耗时757ms左右（5%），使用内存41.3M（5%），主要原因是双循环中肯定有重复的*/

        /*
        * 优化方法一*/
//        int S,maxS=0;
//
//        //优化细节c:j=i+1->i<height.length-1
//        for (int i=0; i<height.length-1; i++)
//
//            //使用j=i+1，减少次数,优化细节b:循环变量内部声明
//            for (int j=i+1; j<height.length; j++){
//
//                //优化细节a:Math.min()
//                S=Math.min(height[i],height[j])*Math.abs(i-j);
//                if (S>maxS){
//                    maxS=S;
//                }
//            }
//        }
//       return maxS;
       /*
       * 耗时487ms左右（10%），使用内存41.6M（5%）*/

        /*
        * 方法二*/
        int maxS=0;

        //从两端开始收缩，互相限制，嵌套内更新循环变量
        for(int i=0, j=height.length-1; i<j;){
            //那边小就收缩哪边
            int low = height[i]<height[j] ? height[i++]:height[j--];
            //###为什么这里要加1？(j-i+1)，
            int S = (j-i+1)*low;
            maxS = Math.max(maxS, S);
        }
        return maxS;
        /*
        * 耗时3ms左右（91%），使用内存41.5M（5%）*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
