class Solution {
public:
    // // Solution 1: using vector.erase() func. --> frequently reassign memory, very slowly
    // int removeDuplicates(vector<int>& nums) {
    //     int uniqueValue = 0x7fffffff;
 
    //     for (auto it  = nums.begin(); it != nums.end();) {
    //         if (*it != uniqueValue) {
    //             uniqueValue = *it;
    //             it++;
    //         } else {
    //             it = nums.erase(it);
    //         }
    //     }
    //     return nums.size();
    // }

    // Solution 2: using vector.resize --> only once reassign memory, very efficient
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }

        int uniqueValue = nums[0];
        int validNum = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != uniqueValue) {
                nums[validNum] = nums[i];
                uniqueValue = nums[i];
                validNum++;
            }
        }
        nums.resize(validNum);

        return nums.size();
    }
 };
