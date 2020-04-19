
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1)return nums.length;
        int i = 0;
        for(int j = 1; j < nums.length;  ++j){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
//写法二
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) count++;
            else nums[i-count] = nums[i];
        }
        return nums.length-count;
    }
}

//刚开始犯了个错误，没认真审题，按照无序排列做的，后来看了题解才反应过来
//两种思路一样的，都是双指针循环，检测相同元素往后交换
