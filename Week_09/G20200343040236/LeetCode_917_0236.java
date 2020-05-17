
class LeetCode_917_0236{
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length;
        int l = -1;
        int r = len;
        if(len < 2 ) return S;
        while(l++ < r--){
            while(l < r && !validLetter(arr[l])) l++;
            while(l < r && !validLetter(arr[r])) r--;
            if(l < r){
                arr[l] ^= arr[r];
                arr[r] ^= arr[l];
                arr[l] ^= arr[r];
            }
        }
        return new String(arr);
    }

    private boolean validLetter(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}