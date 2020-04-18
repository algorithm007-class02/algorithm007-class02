#include<iostream>
#include<vector>
using namespace std;

int findNotSorted(vector<int>& nums){
    int l = 0;
    int r = nums.size()-1;
    while(l<r){
        int mid = l+(r-l+1)/2;
        //拐点在[mid,r]里
        if(nums[mid]>nums[r]){
            l = mid;
        }else{
            //拐点在[l,mid-1]里
            r = mid-1;    
        }
        
    }
    return l;
}


int main(){
    vector<int> test = {3,2};
    vector<int> test1 = {0,1,2,3,4,5,6};
    cout<<findNotSorted(test);


    return 0;
}