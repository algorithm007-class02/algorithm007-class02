//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
/*
 * 查看解答前的思考：
 *   1. 遍历数组中每一个数，当是0时，将该位置后边的数组整体前移动。记录下发现0的次数，然后将新数组后面的若干位赋值为0。
 *       注意，循环时不能重复计算
 *   2. 通过循环将所有非零的数前置（通过双下标变量进行定位），然后将后面的数量变为0。避免了多次整体向前移动的操作*/

class Solution283 {
    public void moveZeroes(int[] nums) {
        /*
        * 方法一*/
//        int i,j,zerocount=0;
//
//        for (i=0; i<nums.length-zerocount; i++){
//            if (nums[i]==0){
//                //若发现0，将后面的数整体前移，nums.length-zerocount-1其实就是原本数组最后一个元素移动后的位置的下标
//                //这里的j=i;非常关键，和下面的i--操作同理，一开始我设置为j=zerocount;会导致跳过未检测元素
//                for (j=i; j<nums.length-zerocount-1; j++){
//                    nums[j]=nums[j+1];
//                }
//
//                //整体前移动后再给zerocount++是为了避免for循环的不彻底
//                zerocount++;
//
//                //zerocount++后nums.length-zerocount就是每次前移后该填0的地方
//                nums[nums.length-zerocount]=0;
//
//                //因为原来i处已经被“检测”过的元素已经前移，为了不因为直接i++导致漏掉检测项，因此每次前移后要将i--，再进行循环中的i++
//                i--;
//            }
//        }
        /*
        * 耗时15ms（9%），内存消耗42M（5%），因为每次找到0都要整体前移，时间和空间的利用效率都很低*/


        /*
        * 方法二*/
        int i,j=0;

        //先通过循环将非零的数都排的数组前面
        for (i=0; i<nums.length; i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }

        //第一个LOOP后的数组里，下标j最后的位置以及j后面的位置，就是要都赋值为0的位置（而且j-1就是该数组内所有非0数的个数）
        for (i=j; i<nums.length; i++){
            nums[i]=0;
        }
        /*
        * 耗时0ms（100%），使用内存42.4M（5%）*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
