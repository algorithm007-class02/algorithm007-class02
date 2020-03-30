class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> um;
        vector<int> res;
        priority_queue<pair<int, int>> pq;
        for(auto n : nums){
            um[n]++;
        }
        for(auto m = um.begin(); m != um.end(); ++m){
            pq.push({m->second, m->first});
        }
        while(res.size() < k){
            res.emplace_back(pq.top().second);
            pq.pop();
        }        
        return res;
    }
};