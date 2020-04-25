//时间复杂度O(n), 只遍历一遍数组
//空间复杂度O(1), 只使用了额外的几个变量
//双指针-令i=0，即第一个元素的值，顺序找到一个值不等于i的位置j， 令nums[i]= nums[j]，i移动到下一个位置。 重复此操作。
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0, j = 1, size = nums.size();
        if(size <= 0) return 0;
        while(j < size){
            while(j < size && nums[i] == nums[j]){
                ++j;
            }
            if(j < size && i + 1 < size){
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
};

//时间复杂度O(n), 只遍历一遍数组
//空间复杂度O(1), 只使用了额外的几个变量
//双指针优化-  上面的两个while可以合并
//class Solution {
// public:
//     int removeDuplicates(vector<int>& nums) {
//         int i = 0, size = nums.size();
//         if(size <= 0) return 0;
//         for(int j = 1; j < size; ++j){
//             if(nums[i] != nums[j]){
//                 nums[++i] = nums[j];
//             }
//         }
//         return i + 1;
//     }
// };

//时间复杂度O(n), 只遍历一遍数组
//空间复杂度O(1), 只使用了额外的几个变量
//int i = !nums.empty()  这里可以少掉一行判断: if(nums.size() < 0) return 0;
// class Solution {
// public:
//     int removeDuplicates(vector<int>& nums) {
//         int i = !nums.empty();
//         for(int n : nums){
//             if(n > nums[i - 1]){
//                 nums[i++] = n;
//             }
//         }
//         return i;
//     }
// };