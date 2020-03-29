//三指针dp
class Solution {
public:
    int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int p1 = 0, p2 = 0, p3 = 0;
        vector<int> dp(n, 1);
        for(int i = 1; i < n; ++i){    
            dp[i] = std::min(std::min(dp[p1] * 2, dp[p2] * 3), dp[p3] * 5);
            if(dp[i] == dp[p1] * 2) ++p1;
            if(dp[i] == dp[p2] * 3) ++p2;
            if(dp[i] == dp[p3] * 5) ++p3;
        }
        return dp[n - 1];
    }
};

//priority_queue
class Solution {
public:
    int nthUglyNumber(int n) {
        priority_queue<long, vector<long>, greater<long>> pq;
        unordered_set<long> s;
        pq.push(1);
        int k = 0;
        vector<long> params {2, 3, 5};
        while(true){
            int value = pq.top();
            pq.pop();
            ++k;
            for(auto param : params){
                if(s.find(param * value) == s.end()){
                    pq.push(param * value);
                    s.insert(param * value);
                }
            }
            if(n == k) return value;
        }
        return 0;
    }
};