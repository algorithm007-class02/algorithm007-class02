#include<iostream>
#include<vector>

using namespace std;


void heapify(vector<int>& nums,int i,int length) {
    int largest = i;
    if(2*i+1<=length) {
        largest = nums[2*i+1]>=nums[largest]?2*i+1:largest;
    }
    if(2*i+2<=length) {
        largest = nums[2*i+2]>=nums[largest]?2*i+2:largest;
    }

    if(largest!=i) {
        swap(nums[i],nums[largest]);
        heapify(nums,largest,length);
    }

    return ;
}
void buildHeap(vector<int>& nums) {
    int n = nums.size();
    for(int i=n/2;i>=0;i--) {
        heapify(nums,i,n-1); 
    }
    return ;
}
void heapSort(vector<int>& nums) {
    //build a Head
    buildHeap(nums);
    //
    int n = nums.size()-1;
    for(int i=n;i>=1;i--) {
        swap(nums[0],nums[i]);
        heapify(nums,0,i-1);
    }
}

int main() {

    vector<int> test = {10,1,5,7,8,6,3,2,4,9};
    heapSort(test);
    for(int i=0;i<test.size();i++) {
        cout<<test[i]<<" ";
    }

    return 0;
}