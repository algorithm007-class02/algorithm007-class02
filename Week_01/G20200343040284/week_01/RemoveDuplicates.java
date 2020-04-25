public class Solution {

    /**
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    /**
     * 旋转数组 1、每次旋转一个元素
     * @param nums
     * @param k
     */
    private static void roate(int[] nums, int k) {
        if(null == nums || nums.length == 0) return;
        int temp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    /**
     * 旋转数组 2、反转数组.反转3次即可得到结果
     * @param nums
     * @param k
     */
    private static void fanzhuan(int[] nums, int k) {
        if(null == nums || nums.length == 0) return;
        // 这里需要对数组的长度取余，否则会数组越界
        k = k % nums.length;
        // 原数组反转
        reverse(nums, 0, nums.length - 1);
        // 反转后的数组, 前半部分反转
        reverse(nums, 0, k - 1);
        // 反转后的数组, 后半部分反转
        reverse(nums, k, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void reverse(int[] nums, int first, int last) {
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first ++;
            last --;
        }
    }

    /**
     * 合并两个有序链表 1、递归
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并两个有序链表 2、预设头节点解法
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode diedai(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * 移动 0 的解法
     * @param nums
     */
    private static void moveZero(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if(i != index ++) {
                    nums[i] = 0;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
