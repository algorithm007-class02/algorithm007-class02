// 国际站大佬牛批
//利用pair记录堆顶下标
// 当堆顶坐标出框的时候 弹出堆顶元素

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res;
        priority_queue<pair<int, int>> pq;
        int n = nums.size();
        for(int i = 0; i < n; ++i){
            while(!pq.empty() && pq.top().second <= i - k)
                pq.pop();
            pq.push(make_pair(nums[i], i));
            if(i - k + 1 >= 0){
                res.emplace_back(pq.top().first);
            }
        }
        return res;
    }
};