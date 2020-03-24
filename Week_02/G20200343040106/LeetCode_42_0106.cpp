// 接雨水
// input: [0,1,0,2,1,0,1,3,2,1,2,1]
// output:6 

// 方法1：双指针 
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int ans = 0;
        int left = 0,right = n-1;
        int lmax = 0,rmax = 0;
        while(left<right){
            if(height[left]<height[right]){
            	//当left的值小于right的值，此时我们处理left处的水量 
            	//因为如果处理right的值
				//并不能保证right左边有没有大于right的值
				//但处理left，可以保证left右侧有大于left处的值 
                if(lmax<=height[left]){
                    lmax = height[left];
                }
                ans+= (lmax-height[left++]);
            }else{
            	//同理 
                if(rmax<=height[right]){
                    rmax = height[right];
                }
                ans+=(rmax-height[right--]);
            }
        }
        return ans;
    }
};
//方法2：栈
class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        int ans = 0;
        for(int i=0;i<height.size();i++){
            while(!s.empty()&&height[i]>height[s.top()]){
                int t = s.top();
                s.pop();
                if(s.empty())
                    break;
                ans+=(min(height[i],height[s.top()])-height[t])*(i-(int)s.top()-1);
            }
            s.push(i);
        }
        return ans;
    }
}; 

