class Solution {
public:
    int trap(vector<int>& height) {
        // 1. 找到左边最大， 右边最大
        // 2. 储水等于 Max(min(leftMax, rightMax)- height, 0)
        // 3. 遍历数组得到ret     
        if (height.size() <  3) return 0;

        int ret = 0;
        int water = 0;
        for ( int i = 1; i < height.size() - 1; i++) {
            int leftMax = GetLeftMax(i - 1, height);
            int rightMax = GetRightMax(i + 1, height);

            water = max( min(leftMax, rightMax) - height[i], 0);
            ret += water;
        }   
        return ret;
    }

    int GetLeftMax(int i, vector<int>& height) {
        int temp = 0;
        for ( ; i >= 0; i--) {
            if ( height[i] >= temp) {
                temp = height[i];
            }
        }
        return temp;
    }

    int GetRightMax(int i, vector<int>& height) {
        int temp = 0;
        for ( ; i < height.size(); i++) {
            if (height[i] >= temp) {
                temp = height[i];
            }
        }
        return temp;
    }
};




// 栈实现
class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0;
        int current = 0;
        stack<int> st;

        while ( current < height.size()) {
            while ( !st.empty() && height[current] > height[st.top()]) {
                int top = st.top();
                st.pop();

                if (st.empty()) break;

                int distance = current - st.top() - 1;
                int bound_height = min(height[current], height[st.top()]) - height[top];
                ans += distance * bound_height;
            }

            st.push(current++);
        }
        
        return ans;
    }
};