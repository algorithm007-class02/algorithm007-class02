#include<iostream>
#include<vector>


using namespace std;

int __partition(vector<int>& nums,int lo,int hi) {
    int v = nums[lo];
    int l = lo;
    int r = hi;
    
    while(l<r) {
        while(l<=hi&&nums[l]<v) l++;
        while(r>=lo&&nums[r]>v) r--;
        if(l>=r) break;
        swap(nums[l],nums[r]);
    }   
    nums[r] = v;
    return r;
}

void __quickSort(vector<int>& nums,int l,int r) {
    if(l>=r) return ;
    int p = __partition(nums,l,r);
    __quickSort(nums,l,p-1);
    __quickSort(nums,p+1,r);
    return ;
}

void quickSort(vector<int>& nums) {
    if(nums.size()<=1) return ;
    __quickSort(nums,0,nums.size()-1);
}

int main() {

    vector<int> test = {10,1,5,7,8,6,3,2,4,9};
    quickSort(test);
    for(int i=0;i<test.size();i++) {
        cout<<test[i]<<" ";
    }

    return 0;
}