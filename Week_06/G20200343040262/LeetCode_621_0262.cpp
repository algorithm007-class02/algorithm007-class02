class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int len = tasks.size();
        if (len == 0 || n < 0) return 0;
        vector<int> count(26, 0);
        for (int i = 0; i < len; ++i) {//计算频度
            count[tasks[i] - 65]++;
        }
        sort(count.begin(), count.end());
        int result = (count[25] - 1) * (n + 1);
        for (int j = 25; j >= 0 && count[j] == count[25]; --j) {
            ++result;
        }
        return result > len? result : len;
    }
};