/*̰�ķ�
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�O(1)*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty())
            return 0;
             
        int max = 0;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices[i] < prices[i+1])
                max += prices[i+1] - prices[i];
        }
        return max;
    }
};