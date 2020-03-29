#include <vector>
#include <algorithm>

class Solution {
public:
    int trap(vector<int>& height) {
        // (min(maxLeftBound, maxRightBound) - cur) >= 0 ? self : 0
        int n = height.size();
        std::vector<int> maxLBound(n, 0);
        std::vector<int> maxRBound(n, 0);

        for (int i = 1; i < n; i++) {
            maxLBound[i] = std::max(height[i-1], maxLBound[i-1]);
        }
        for (int i = n-2; i >= 0; i--) {
            maxRBound[i] = std::max(height[i+1], maxRBound[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += std::max(0, std::min(maxRBound[i], maxLBound[i]) - height[i]); 
        }
        return sum;
    }
};
