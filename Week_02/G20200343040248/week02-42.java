//暴力求解,指针i从左到右遍历，指针j表示从i开始，每个i都遍历左边和右边，找到所有的面积相加，每个i都要左右遍历
//所以时间复杂度为O(n^2)
int trap(int* height, int heightSize){
    int ans = 0;
    int size = heightSize;
    for(int i = 1; i < size - 1; i++){
        int max_left = 0, max_right = 0;
        for(int j = i; j >= 0; j--){
            max_left = fmax(max_left, height[j]);
        }
        for(int j = i; j < size; j++){
            max_right = fmax(max_right, height[j]);
        }
        ans += fmin(max_left, max_right) - height[i];
    }
    return ans;
}
//上面的方法有重复计算的值，提前存好计算过的值，减少了一次遍历的时间，整体复杂度就变成O(n)，但是空间复杂度多了两个数组。
int trap(int* height, int heightSize){
    if(heightSize == 0)return 0;
    int ans = 0;
    int left_max[heightSize];
    int right_max[heightSize];
    left_max[0] = height[0];
    for(int i = 1; i < heightSize; i++){
        left_max[i] = fmax(height[i], left_max[i-1]);
    }
    right_max[heightSize - 1] = height[heightSize-1];
    for(int i = heightSize - 2; i>=0; i--){
        right_max[i] = fmax(height[i], right_max[i+1]);
    }
    for(int i = 1; i< heightSize - 1; i++){
        ans += fmin(left_max[i], right_max[i]) - height[i];
    }
    return ans;
}
//使用栈,类似于找匹配括号的问题。
//我们在遍历数组时维护一个栈。
//如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
//如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到ans。
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int top = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[stack.peek()], height[current])- top;
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}
//双指针法,我们可以认为如果一端有更高的条形块，积水的高度依赖于当前方向的高度。
//当我们发现另一侧的条形块高度不是最高的，我们则开始从相反的方向遍历。
int trap(int* height, int heightSize){
    int left = 0;
    int right = heightSize - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if(height[left] >= left_max)  {
                left_max = height[left];
            }else{
                ans += (left_max - height[left]);
            }
            ++left;
        }
        else {
            if(height[right] >= right_max){
                right_max = height[right];
            }else{
                ans += (right_max - height[right]);
            }
            --right;
        }
    }
    return ans;
}