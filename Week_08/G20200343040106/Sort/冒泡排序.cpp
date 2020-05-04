#include<iostream>
#include<vector>
using namespace std;

void bubbleSort(vector<int>& nums) {
    int n = nums.size();
    if(n<=1) return ;
    for(int i=n-1;i>=1;i--) {
        for(int j=1;j<=i;j++) {
            if(nums[j]<=nums[j-1]) {
                swap(nums[j],nums[j-1]);
            }
        }
    }
    return ;
}


int main() {

    vector<int> test = {10,1,5,7,8,6,3,2,4,9};
    bubbleSort(test);
    for(int i=0;i<test.size();i++) {
        cout<<test[i]<<" ";
    }

    return 0;
}