//跳跃游戏2

//我总感觉这题有一丝BFS的味道
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n<=1) return 0;
        int ans = 0;
        int mostfar = 0;
        int nextmostfar = min(nums[0],n-1);
        for(int i=0;i<nums.size();i++){
            nextmostfar = min(max(nextmostfar,i+nums[i]),n-1);
            if(i==mostfar){
                ans++;
                mostfar = nextmostfar;
                if(mostfar==n-1) return ans;
            }

        }
        return -1;   //永远不会执行到这
    }
};