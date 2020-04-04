class Solution {
public:
    int jump(vector<int>& nums) {
        int res = 1;
        int end = nums.size() - 1;
        if (end == 0) return 0;
        int cur = 0;
        while (cur + nums[cur] < end) {//next step can't reach end
            int next = cur + nums[cur];//next step
            for (int i = nums[cur]; i > 0; i--) {
                if (nums[i + cur] > nums[next] && (i + cur + nums[i + cur]) > (next + nums[next])) next = i + cur;
            }
            res++;
            cur = next;
        }
        return res;
    }
};