// 超时
class Solution {
public:
    int climbStairs(int n) {
        return helper(n);
    }

    int helper(const int& n) {
        // 1. terminator
        if ( n <= 2) return n;
        // 2. process
        return helper(n - 1) + helper(n - 2);
        // 3. drill down
        // 4. clear state
    }
};


//  实际， 维护一个 map 保存已经出现过的状态
class Solution {
public:
    int climbStairs(int n) {
        return helper(n);
    }

    int helper(const int& n) {
        // 1. terminator
        if ( n <= 2) return n;

        if (mp.find(n-1) == mp.end()) mp.insert(make_pair(n-1, helper(n - 1)));

        if (mp.find(n-2) == mp.end()) mp.insert(make_pair(n-2, helper(n - 2)));

        f1 = mp[n - 1];
        f2 = mp[n - 2];

        // 2. process
        return f1 + f2;
        // 3. drill down
        // 4. clear state
    }

private:
    map<int, int> mp;        
    int           f1;
    int           f2;
};