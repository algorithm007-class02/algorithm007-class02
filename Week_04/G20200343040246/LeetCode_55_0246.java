package Week_04.G20200343040246;

class LeetCode_55_0246 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new LeetCode_55_0246().canJump(nums));
        System.out.println(new LeetCode_55_0246().canJump1(nums));
    }

    // 从前往后
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) {return false;}
            max = Math.max(nums[i]+i, max);
        }
        return true;
    }

    // 从后往前
    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}