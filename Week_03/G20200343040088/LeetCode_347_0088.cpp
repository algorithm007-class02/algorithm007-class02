class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pqueue;
        unordered_map<int, int> map;

        for (auto val : nums) {
            map[val]++;
        }

        for (auto kv : map) {
            pqueue.push({kv.second, kv.first});
            while(pqueue.size() > k) pqueue.pop();
        }

        vector<int> res;
        while(!pqueue.empty()) {
            res.push_back(pqueue.top().second);
            pqueue.pop();
        }

        return res;
    }
};