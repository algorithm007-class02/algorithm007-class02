/*solution ways:
1.sort: O(NlogN)
2.heap: O(NlogK)
3.quick-sort
*/
//2.heap time(NlogK) space(K)
class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        vector<int> res(k, 0);
        if (k == 0) return res;
        priority_queue<int> heap;
        for (int i = 0; i < k; i++) heap.push(arr[i]);
        for (int i = k; i < arr.size(); i++) {
            if (heap.top() > arr[i]) {
                heap.pop();
                heap.push(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.top();
            heap.pop();
        }
        return res;
    }
};