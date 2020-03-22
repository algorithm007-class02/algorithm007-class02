class Solution {
public:
    int trap(vector<int>& height) {
        int len=height.size();
        int res=0;
        vector<vector<int>> pool(len,vector<int>(2,0));
        int lmax=0,rmax=0;
        //前两个循环是找到每个节点左右的最高点，
        for(int i=0;i<len;i++){                    //左边最高，称之为左峰
            lmax=height[i]>lmax?height[i]:lmax;
            pool[i][0]=lmax;
        }
        for(int i=len-1;i>=0;i--){
            rmax=height[i]>rmax?height[i]:rmax;    //右边最高，称之为右峰
            pool[i][1]=rmax;
        }
        for(int i=0;i<len-1;i++){                  //每个点做谷，左右峰低的那个减去这个点的高度
            int temp=min(pool[i][0],pool[i][1])-height[i];
            res+=temp;                        
        }
        return res;
    }
};