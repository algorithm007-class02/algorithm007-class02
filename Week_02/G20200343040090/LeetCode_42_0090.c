/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
*/

class Solution {
public:
    int trap(vector<int>& height) {
        if(2 >= height.size())
        {
            return 0;
        }

        /*栈里保存了指定列右边的最大值*/
        stack<int> rightMaxStack;
        int tmpRightMax = 0;
        /*下面的for循环从1开始计算，stack从2开始*/
        for(int k = height.size()-1; k > 1; k--)
        {
            if(height[k] > tmpRightMax)
            {
                tmpRightMax = height[k];
            }
            rightMaxStack.push(tmpRightMax);
        }

        int maxRain = 0;
        int leftMax = height[0];
        int rightMax = 0;
        /*两边最外面的柱子无法接雨水*/
        for(int i = 1; i < height.size()-1; i++)
        {
            /*找右边最大值*/    
            rightMax = rightMaxStack.top();   
            rightMaxStack.pop();

            if(leftMax > height[i] && rightMax > height[i]) 
            {
                maxRain += leftMax > rightMax?(rightMax-height[i]):(leftMax-height[i]);
            }

            /*保留左边最大值*/
            if(height[i] > leftMax)
            {
                leftMax = height[i];
            }
        }

        return maxRain;
    }
};