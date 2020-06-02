class Solution {
    //小于等于2k大于等于k都反转前k个，小于k，反转剩下的全部
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int start = 0;start < arr.length; start += 2 * k){
            int i = start,j = Math.min(start + k - 1,arr.length - 1);
            while(i < j){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}