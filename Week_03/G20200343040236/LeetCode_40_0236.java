import java.util.PriorityQueue;
class LeetCode_40_0236{
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0;i<arr.length;i++){
            heap.add(arr[i]);
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = heap.poll();
        } 
        return ans;
    }
}