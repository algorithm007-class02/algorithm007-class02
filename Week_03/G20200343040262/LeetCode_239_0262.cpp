/*
思路：
方法一：暴力求解：从0 到 length - k 遍历，每次计算k大小窗口内最大值，复杂度O(nk)
方法二：单调队列：遍历一遍即可，遍历时仍在队尾添加元素，但要把前面比新元素小的元素都删掉
Way 3.heap by the method of priority_queue
*/
//滑动窗口最大值
//3.heap, priority_queue
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res;
        if(k == 0 || nums.size() == 0) return res;
        priority_queue<int> heap;
        priority_queue<int> del_heap;
        for (int i = 0; i < nums.size(); i++) {
            heap.push(nums[i]);
            if (i < k - 1) continue;
            res.push_back(heap.top());
            del_heap.push(nums[i - k + 1]);
            while (!heap.empty() && !del_heap.empty() && heap.top() == del_heap.top()) {
                heap.pop();
                del_heap.pop();
            }
        }
        return res;
    }
};