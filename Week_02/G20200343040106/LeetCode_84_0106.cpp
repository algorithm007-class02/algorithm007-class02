class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> s;
        s.push(-1);    //方便处理 
        int ans = 0;
        for(int i=0;i<heights.size();i++){
            if(s.top()!=-1&&heights[i]<heights[s.top()]){
            	//当遇到第i个元素小于栈顶元素时
				//这时说明，栈顶元素的左右边界找到了。
				//左边界为 栈顶下的元素，有边界为i 
                while(s.top()!=-1&&heights[s.top()]>=heights[i]){
                    int temp = s.top();
                    s.pop();
                    ans = max(ans,heights[temp]*(i-s.top()-1));
                }
            }
            s.push(i);
        }
        //此时若栈非空，说明栈里面是递增的。
		//栈里元素的右边界为 heights.lenght。很好理解。 
        while(s.top()!=-1){
            int temp = s.top();
            s.pop();
            ans = max(ans,heights[temp]*((int)heights.size()-s.top()-1));
        }
        return ans;
    }
};
