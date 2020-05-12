class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> count = vector<int>(1001,0);
        for(int i=0;i<arr1.size();i++) {
            count[arr1[i]] ++;
        }

        vector<int> ans;
        for(int i=0;i<arr2.size();i++) {
            while(count[arr2[i]]!=0) {
                ans.push_back(arr2[i]);
                count[arr2[i]] --;
            }
        }

        for(int i=0;i<=1000;i++) {
            while(count[i]!=0) {
                ans.push_back(i);
                count[i] --;
            }
        }
        return ans;
    }
};