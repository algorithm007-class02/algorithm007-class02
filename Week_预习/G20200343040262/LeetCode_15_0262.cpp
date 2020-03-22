/*
LeetCode
（三数之和）题目15描述：
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
*/

//1、暴力求解法，先求任意两个数之后，取负数后，逐一对比(三重循环，O(n ^ 3))
//2、三指针法，遍历指针i，左指针l，右指针r，此处采用方法2
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());//先排序，从小到大排
        int N = nums.size();
        vector<vector<int>> res;
        for (int i = 0; i < N - 2; i++) {
            if (nums[i] > 0) break;//如果数组最小值都大于0，那数组任意三数和都不可能为0
            if (i > 0 && nums[i] == nums[i - 1]) continue;//如果接连几项数值相同，则可跳过
            int l = i + 1;//左指针
            int r = N - 1;//右指针
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0 ) {
                    r--;//r向左收敛，以求减小三数之和sum
                }
                else if (sum < 0) {
                    l++;//l向右收敛，以求增大三数之和sum
                }
                else {//找到符合要求的元素
                    res.push_back({nums[i], nums[l], nums[r]});
                    while (l < r && nums[l] == nums[++l]) ;//跳过重复项,l先自增，简略写法
                    while (l < r && nums[r] == nums[--r]) ;//跳过重复项
                }
                
            }
            
        }
        return res;
    }
};