// ����ˮ
// input: [0,1,0,2,1,0,1,3,2,1,2,1]
// output:6 

// ����1��˫ָ�� 
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int ans = 0;
        int left = 0,right = n-1;
        int lmax = 0,rmax = 0;
        while(left<right){
            if(height[left]<height[right]){
            	//��left��ֵС��right��ֵ����ʱ���Ǵ���left����ˮ�� 
            	//��Ϊ�������right��ֵ
				//�����ܱ�֤right�����û�д���right��ֵ
				//������left�����Ա�֤left�Ҳ��д���left����ֵ 
                if(lmax<=height[left]){
                    lmax = height[left];
                }
                ans+= (lmax-height[left++]);
            }else{
            	//ͬ�� 
                if(rmax<=height[right]){
                    rmax = height[right];
                }
                ans+=(rmax-height[right--]);
            }
        }
        return ans;
    }
};
//����2��ջ
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

