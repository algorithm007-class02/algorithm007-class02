//维护小顶堆，删除频次低的元素，最后再翻转
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> res;
        if (k == 0 || nums.size() == 0) return res;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> min_heap;//用小顶堆
        unordered_map<int, int> cnt;
        for (auto num : nums) cnt[num]++;
        for (auto ele : cnt) {
            min_heap.push(make_pair(ele.second, ele.first));
            while (min_heap.size() > k) min_heap.pop();
        }
        while (!min_heap.empty()) {
            res.push_back(min_heap.top().second);
            min_heap.pop();
        }
        reverse(res.begin(),res.end());
        return res;
    }
};