class Solution {
    public int countSubstrings(String s) {
        //暴力法 遍历所有组合 //判断是否为回文
        int count = 0;
        int sLen = s.length();
        for(int i = 0; i < sLen - 1; i++){
            for(int j = i + 1; j < sLen; j++){
                String subStr = s.substring(i,j + 1);
                if(isPlalindrome(subStr)){
                    count++;
                }
            }
        }
        return count + sLen;
    }

    public boolean isPlalindrome(String str){
        //向内夹逼
        int preIndex = 0;
        int sufIndex = str.length() - 1;
        while (preIndex < sufIndex){
            if(str.charAt(preIndex) != str.charAt(sufIndex)){
                return false;
            }
            preIndex++;
            sufIndex--;
        }
        return true;
    }
}