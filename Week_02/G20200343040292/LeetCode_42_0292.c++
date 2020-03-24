//暴力法 时间复杂度:O(n^2) 空间复杂度:O(1)
class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0;
        for (int i = 0; i < height.size(); i++) {
            int left_max = 0, right_max = 0;
            for (int j = i; j >= 0; j--) {
                left_max = max(left_max, height[j]);
            }
            for (int j = i; j <height.size(); j++) {
                right_max = max(right_max, height[j]);
            }
            ans += min(left_max, right_max) - height[i];
        }   
        return ans;      
    }
};

//动态编程 时间复杂度：O(n) 空间复杂度：O(n)
class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() == 0)
            return 0;

        int ans = 0;
        int size = height.size();
        vector<int> left_max(size), right_max(size);
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = max(left_max[i-1], height[i]);
        }
        right_max[size-1] = height[size-1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = max(right_max[i+1], height[i]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
};

//使用栈 时间复杂度：O(n) 空间复杂度：O(n)
class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0, current = 0;
        stack<int> st;

        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.top() - 1;
                int bounded_height = min(height[current], height[st.top()]) - height[top];
                ans += bounded_height * distance;
            }
            st.push(current++);
        }
        return ans;
    }
}; 

//双指针法 时间复杂度：O(n) 空间复杂度：O(1)
class Solution {
public:
    int trap(vector<int>& height) {
       int l = 0, r = height.size() - 1;
       int level = 0, water = 0;

       while (l < r) {
           int lower = height[height[l] < height[r] ? l++ : r--];
           level = max(level, lower);
           water += level - lower;
       }
       return water;
    }
};