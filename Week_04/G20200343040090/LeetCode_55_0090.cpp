/*
55. 跳跃游戏
*/

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k = 0;

        for(int i = 0; i < nums.size(); i++)
        {
            if(i > k) return false;//能跳到的覆盖范围比走到的要小，返回false
            k = max(k, i + nums[i]);//k表示覆盖的索引范围
        }

        return true;
    }
};