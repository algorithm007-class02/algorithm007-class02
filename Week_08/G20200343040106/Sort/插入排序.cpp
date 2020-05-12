#include<iostream>
#include<vector>

using namespace std;

void insertSort(vector<int>& nums) {
    int n = nums.size();
    if(n<=1) return ;

    for(int i=1;i<n;i++) {
        int temp = nums[i];
        int j = i-1;
        while(j>=0&&nums[j]>=temp) {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = temp;
    }

    return ;
}


int main() {

    vector<int> test = {10,1,5,7,8,6,3,2,4,9};
    insertSort(test);
    for(int i=0;i<test.size();i++) {
        cout<<test[i]<<" ";
    }

    return 0;
}