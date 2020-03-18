学习笔记

因为之前在这方面基本没有基础,虽然学习很吃力一点,但是覃超老师讲得很好,希望自己一直坚持下去





三数之和               --15

 public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;

```
        if (k > 0 && nums[k] == nums[k - 1]) continue;
        int i = k + 1, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[k] + nums[j];
            if (sum < 0) {
                while (i < j && nums[i] == nums[++i]) ;
            } else if (sum > 0) {
                while (i < j && nums[j] == nums[--j]) ;
            } else {
                res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                while (i < j && nums[i] == nums[++i]) ;
                while (i < j && nums[j] == nums[--j]) ;
            }
        }
    }
    return res;
```

```
排完序以后,如果刚开始便大于0,直接break;
nums[k] == nums[k - 1]) 直接 continue,因为会产生重复的结果;
三数字和  采用双指针,如果sum小于0,左指针右移,如果sum>0,右指针左移,如果等于0,添加到list
并且双指针继续合并,寻找下一组合
```

