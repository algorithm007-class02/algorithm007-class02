//面试题40. 最小的k个数
class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        priority_queue<int> pq;
        vector<int> res;
        for(auto n : arr){
            pq.emplace(n);
            if(pq.size() > k) pq.pop();
        }
        while(!pq.empty()){
            res.emplace_back(pq.top());
            pq.pop();
        }
        return res;
    }
};