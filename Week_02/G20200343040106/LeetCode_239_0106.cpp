class Solution {
public:
	class MaxQueue {
    public:
        MaxQueue() {
            //op
        }
        int max_value() {
            if(d.empty())
                return -1;
            return d.back();
        }
        
        void push_back(int value) {
            while(!d.empty()&&d.front()<value){
                d.pop_front();
            }
            d.push_front(value);
            q.push(value);
        }
        
        int pop_front() {
            if(q.empty())
                return -1;
            int ans = q.front();
            q.pop();
            if(ans==d.back()){
                d.pop_back();
            }
            return ans;
        }
    private:
        queue<int> q;
        deque<int> d;
 	};
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        int n = nums.size();
        if(!n||!k)
            return ans;
        MaxQueue myqueue;    // 可以再O(1)时间检索最大值的队列。 
        for(int i=0;i<k;i++){
            myqueue.push_back(nums[i]);
        }
        ans.push_back(myqueue.max_value());
        for(int i=k;i<nums.size();i++){
            myqueue.pop_front();
            myqueue.push_back(nums[i]);
            ans.push_back(myqueue.max_value());
        }
        return ans;
    }
};
