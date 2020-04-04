class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        if ( k > n) return vecRet;

        vector<int> vec;
        helper(1, k, n, vec);
        return vecRet;
    }


    void helper(int level, int k, int n, vector<int> vec) {
        // 1. terminator
        if ( vec.size() == k) {
            vecRet.push_back(vec);
            return;
        }

        for ( int i = level; i <= n ; i++) {
            vec.push_back(i);
            helper(i + 1, k, n, vec);
            vec.pop_back();
        }
    }

private:
    vector<vector<int>> vecRet;
};