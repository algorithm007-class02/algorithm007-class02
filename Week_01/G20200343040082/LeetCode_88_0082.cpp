
#include <vector>

// 1. 先合并再排序

void qSort(int left, int right, vector<int> & nums) {

    if (left >= right) return;

    int l, r, base, temp;

    while(l < r) {
        while (nums[r] >= base && r > l)
            r--;
        
        while (nums[l] <= base && r > l) 
            l++;

        if (r > l) {
            nums[l] += nums[r];
            nums[r] -= nums[l];
            nums[r] = -nums[r];
            nums[l] -= nums[r];
        }
    }

    nums[left] = nums[l];
    nums[l] = base;

    qSort(left, l-1, nums);
    qSort(l+1, right, nums);
}

void merge(vector<int>& num1, int m, vector<int>& num2, int n) {

    int i=0;
    while (i < n) {
        num1[m++] = num2[i++];
    }

    qSort(0, num1.size()-1, num1);
}

// 2. 双指针
void merge2(vector<int>& num1, int m, vector<int>& num2, int n) {
    int i, j, len;

    i = m-1;
    j = n-1;
    len = m+n-1;

    while (i>=0 && j >= 0) {
        num1[len--] = num1[i] > num2[j] ? num1[i--]:num2[j--];
    }

    while (j >= 0) {
        num1[len--] = num2[j--];
    }
}