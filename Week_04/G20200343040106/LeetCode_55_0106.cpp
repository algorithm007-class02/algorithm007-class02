//跳跃游戏
// 思路1：dfs 暴力枚举所有可能的路径，发现到了最后一个位置retur true
// 思路2: 优化思路一，上述dfs涉及很多重复解，我们引用mem数组，将之改进为记忆化搜索的动态规划解法
// 思路3: greedy，我们维护一个跳至最远的量，并不断更新它。

// dfs
// 不出意外的TLE了
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()<=1)
            return true;
        return backTrace(nums,0);
    }

    bool backTrace(vector<int>& nums,int curLevel){
        if(curLevel==nums.size()-1) return true;
        bool res = false;
        int furtherMax = min(curLevel+nums[curLevel],(int)nums.size()-1);
        for(int nextLevel = curLevel+1;nextLevel<=furtherMax;nextLevel++){
            res |= backTrace(nums,nextLevel);
        }
        return res;
    }
};

// 记忆化搜索  (ps:事实上，这已经是动态规划的解法了)
class Solution {
public:
    vector<int> mem;
    bool canJump(vector<int>& nums) {
        if(nums.size()<=1)
            return true;
        mem = vector<int>(nums.size(),-1);
        return backTrace(nums,0);
    }

    bool backTrace(vector<int>& nums,int curLevel){
        if(curLevel==nums.size()-1) return true;
        bool res = false;
        int furtherMax = min(curLevel+nums[curLevel],(int)nums.size()-1);
        for(int nextLevel = curLevel+1;nextLevel<=furtherMax;nextLevel++)        {
            if(mem[nextLevel]==-1){
                mem[nextLevel] = backTrace(nums,nextLevel);
            }
            res|= mem[nextLevel];
        }
        return res;
    }
};
// 自底向上，DP

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n<=1)
            return true;
        bool dp[n];
        dp[n-1] = true;
        for(int i=n-2;i>=0;i--){
            dp[i] = false;
            int furtherMax = min(n-1,i+nums[i]);
            for(int j=i+1;j<=furtherMax;j++){
                dp[i]|=dp[j];
            }
        }
        return dp[0];
    }
};


//greedy

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int cur = 0;
        for(int i=0;i<nums.size();i++){
            if(i>cur)
                return false;
            cur = max(cur,i+nums[i]);
        }
        return true;
    }
};