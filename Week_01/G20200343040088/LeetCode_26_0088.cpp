class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;

        int j = 0;
        int i = 1;
        while ( i < nums.size() ) 
        {
            if(nums[j] != nums[i]) {
                nums[j + 1] = nums[i];
                j++;
            }

            i++;
        }

        return j + 1;
    }
};

// 时间复杂度： O(n)
// 空间复杂度 O(1)


// 方法1：  2重循环，重复的元素改为特殊标记，例如数组大小。 最后再做1次轮询统计有多少位子被标记。数组大小减去被标记多少个即可

// 方法2： 排序数组，2个指针， i 遍历数组， 不一样的放到j的地方 