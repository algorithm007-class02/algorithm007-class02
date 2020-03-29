class week02 {
    /**
     * 1. 两数之和
     * solution 1 -- O(n*n)：
     * get a *********************** [loop] O(n)
     * get b *********************** [loop] O(n)
     * judge (a + b == target)? **** O(1)
     * 
     * solution 2:
     * get a *********************** [loop] O(n)
     * calculate (b = target - a) ** O(1)
     * judge (b in nums) *********** [hash]O(1)
     * 
     * 思考：
     * 给定的数组内，[基础值 & 限定条件 --> 目标值]，这一类问题是否都可以只做一次遍历？
     * 猜想：
     * 1、再类比双指针，loop外的 指针\HASH 存储目标值的地址，从而将solution1内的 [get b] 操作 由O(n)简化为O(1)
     * 2、先想到目标值的获取途径，再想到实现方式
     *      降级时间复杂度，就是降级目标值的获取方式，这里是利用hash取值O(1)
     * 3、由于在同一数组内，所以可以在后半程的基础值中 去查前半程的目标值，从而实现了两次hash降为一次hash
     * 实现：
     * 继续刷题，看看有没有类似的思路
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (map.containsKey(num2)) {
                // 这里有个小细节，使用一次hash，i 均为后面的数字，为了美观，返回时目标值在前 基础值在后
                return new int[]{map.get(num2), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}