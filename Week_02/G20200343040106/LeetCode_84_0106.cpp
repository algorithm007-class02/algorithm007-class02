class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> s;
        s.push(-1);    //���㴦�� 
        int ans = 0;
        for(int i=0;i<heights.size();i++){
            if(s.top()!=-1&&heights[i]<heights[s.top()]){
            	//��������i��Ԫ��С��ջ��Ԫ��ʱ
				//��ʱ˵����ջ��Ԫ�ص����ұ߽��ҵ��ˡ�
				//��߽�Ϊ ջ���µ�Ԫ�أ��б߽�Ϊi 
                while(s.top()!=-1&&heights[s.top()]>=heights[i]){
                    int temp = s.top();
                    s.pop();
                    ans = max(ans,heights[temp]*(i-s.top()-1));
                }
            }
            s.push(i);
        }
        //��ʱ��ջ�ǿգ�˵��ջ�����ǵ����ġ�
		//ջ��Ԫ�ص��ұ߽�Ϊ heights.lenght���ܺ���⡣ 
        while(s.top()!=-1){
            int temp = s.top();
            s.pop();
            ans = max(ans,heights[temp]*((int)heights.size()-s.top()-1));
        }
        return ans;
    }
};
