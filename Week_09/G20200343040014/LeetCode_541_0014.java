class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        if (k == 1) return s;
        int count = len/(2*k);
        String res = "";
        for (int i = 0 ; i< count; i++){
            String sub = s.substring(i,2*k+i);
            sub = revertString(sub,k);
            res+=sub;
        }
        int left = len%(2*k);
        String sub = s.substring(len - left,len);
        if (left < k){
            sub = revertString(sub, left);
        }else{
            sub = revertString(sub, k);
        }
        res += sub;
        return res;
    }
    public String revertString(String s, int k){
        char[] arr = s.toCharArray();
        for (int i = 0,j = k-1; i < j; i++,j--){
            arr[i]^=arr[j];
            arr[j]^=arr[i];
            arr[i]^=arr[j];
        }
        System.out.println(s);
        return String.valueOf(arr);
    }
}