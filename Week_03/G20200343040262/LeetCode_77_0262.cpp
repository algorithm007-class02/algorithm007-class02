//Backtracking
class Solution {
private:
    vector<vector<int>> res;
    void findCombinations(int n, int k, int index, vector<int> p) {
        if (p.size() == k) {//够数了，加入结果集
            res.push_back(p);
            return;
        }
        // i 的极限值满足： n - i + 1 = (k - pre.size())。
        // n - i + 1 是闭区间 [i,n] 的长度。
        // k - pre.size() 是剩下还要寻找的数的个数。
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {//已经剪枝
            p.push_back(i);
            findCombinations(n, k, i + 1,p);
            p.pop_back();//回溯
        }
    }
public:
    vector<vector<int>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) return res;
        vector<int> p;
        findCombinations(n, k, 1, p);
        return res;
    }
};