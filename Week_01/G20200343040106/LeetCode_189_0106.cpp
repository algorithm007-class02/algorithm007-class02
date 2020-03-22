
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(n)
            k = k%n;
        if(!n||!k)
            return ;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        return ;
    }
    void reverse(vector<int>& nums,int begin,int end){
        while(begin<end){
            swap(nums[begin++],nums[end--]);
        }
        return ;
    }
};
