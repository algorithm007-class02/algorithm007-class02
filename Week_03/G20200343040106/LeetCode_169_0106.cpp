#include<vector>
using namespace std;
// 思路一：哈希表   
// 思路二：排序
// 思路三：分治  nums[l..r]的众数取决为 numd[l...mid]和nums[mid+1...r]
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        return recursion(nums,0,(int)nums.size()-1);
    }

    int recursion(vector<int>& nums,int l,int r){
        if(l==r){
            return nums[l];
        }
        int mid = l+(r-l)/2;
        int left = recursion(nums,l,mid);
        int right = recursion(nums,mid+1,r);
        if(left==right)
            return left;
        int leftcount = countRange(nums,l,r,left);
        int rightcount = countRange(nums,l,r,right);
        return leftcount>=rightcount?left:right;
    }

    int countRange(vector<int>& nums,int l,int r,int target){
        int ans = 0;
        for(int i=l;i<=r;i++){
            if(nums[i]==target)
                ans++;
        }
        return ans;
    }
};

// 思路四：Boyer-Moore 投票算法
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majority = 0;
        int cnt = 0;
        for(int i=0;i<nums.size();i++){
            if(cnt==0){
                majority = nums[i];
                cnt =  1;
            }else{
                if(nums[i]==majority)
                    cnt++;
                else   
                    cnt--;
            }
        }
        return majority;
    }
};