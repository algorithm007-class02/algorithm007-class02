/*
LeetCode
（盛最多水的容器）题目11描述：
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
*/

class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();//垂直线条数n
        int i,j;//i从左往右遍历，j从右往左遍历
        int maxLevel = 0;//最大容水量
        for (i = 0, j = n - 1; i < j; ) {

            int widthN,heightN;//容器宽度、高度
            int CurrentLevel;//当前最大容量
            if (height[i] < height[j]) {
                CurrentLevel = (j - i) * height[i];
                i++;
            }
            else {
                CurrentLevel = (j - i) * height[j];
                j--;
            }
            if (CurrentLevel > maxLevel) {
                maxLevel = CurrentLevel;
            }
        }
        return maxLevel;
    }
};