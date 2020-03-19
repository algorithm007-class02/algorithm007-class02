class LeetCode_2_0068 {

    //1。 两个for 循环，每次移一步
    //2。
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1], tmp;
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }

    }


}