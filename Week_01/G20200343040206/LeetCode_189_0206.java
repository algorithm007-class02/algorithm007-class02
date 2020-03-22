
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组

public class LeetCode_189_0206 {


    /**
     * 1、简单暴力法：一次一次右旋
     * 2、复制一份原数组，然后按照最终的位置放置
     * 3、循环替换，每次查被替换的元素的最终位置，但是有整除的问题
     * <p>
     * 补充题解答案给出的解法
     * 1、数组翻转，三次翻转
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        //先用第一种方法试一试
        //时间复杂度k*O（n）
        //空间复杂度为O（1）
        if (nums == null || nums.length == 1 || k == 0) {
            return;
        }

        k = k % nums.length;

        int lastNum;
        for (int i = 0; i < k; i++) {
            lastNum = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = lastNum;
        }
    }

    public void rotate_2(int[] nums, int k) {
        //再用第二种方法试一试
        //时间复杂度O（n）
        //空间复杂度为O（n）
        if (nums == null || nums.length == 1 || k == 0) {
            return;
        }

        int[] copy_nums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            nums[index] = copy_nums[i];
        }
    }


    public void rotate_3(int[] nums, int k) {
        ///继续改进，是否可以不用空间O（n）
        //直接交换位置，直到所有都交换过
        //整除的时候，要破除循环:当前要移动的位置与之前作比较
        //时间复杂度O（n）
        //空间复杂度为O（1）
        if (nums == null || nums.length == 1) {
            return;
        }

        k = k % nums.length;

        if( k == 0){
            return;
        }

        int start = 0;
        int pre = start;
        for (int count = 0; count < nums.length; count++) {
            int current = (pre + k) % nums.length;
            if(current == start) {
                start++;
                pre = start;
                continue;
            }

            int temp = nums[current];
            nums[current] = nums[start];
            nums[start] = temp;

            pre = current;
        }
    }

    public void rotate_3_1(int[] nums, int k) {
        ////参考标准答案学习
        //直接交换位置，直到所有都交换过
        //整除的时候，要破除循环:当前要移动的位置与之前作比较
        //时间复杂度O（n）
        //空间复杂度为O（1）
        if (nums == null || nums.length == 1 || k == 0) {
            return;
        }

        k = k % nums.length;

        int count = 0;
        for (int start = 0; count < nums.length; start++) {

            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;

                int temp = nums[next];
                nums[next] = pre;
                pre = temp;

                current = next;
                count++;
            } while (start != current);

        }
    }


    public void rotate_4(int[] nums, int k) {
        ///参考标准答案学习
        //翻转数组
        //时间复杂度O（n）
        //空间复杂度为O（1）
        if (nums == null || nums.length == 1 || k == 0) {
            return;
        }

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeetCode_189_0206 src = new LeetCode_189_0206();

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        src.rotate(nums,k);
        System.out.println(nums.toString());

//        int[] nums = new int[]{-1, -100, 3, 99};
//        int k = 2;
//        src.rotate_3_1(nums, k);
//        System.out.println(nums.toString());
    }

}
