class Solution {
    public boolean validPalindrome(String s) {
            //两边向内夹逼
            //如果遇到不同 则删除一个 //删除后如果还是不同则直接返回false
            int leftIndex = 0;
            int rightIndex = s.length() - 1;
            boolean deleted = false;
            while (rightIndex > leftIndex){
                if(s.charAt(rightIndex) != s.charAt(leftIndex)){
                    if(deleted) return false;
                    //右删 左删
                    if(isPalindrome(s, leftIndex + 1, rightIndex )) {
                        leftIndex ++;
                    }
                    else if(isPalindrome(s, leftIndex, rightIndex - 1)){
                            rightIndex--;
                    }
                    else {
                            return false;
                    }
                    
                    
                    deleted = true;
                }
                rightIndex --;
                leftIndex ++;
            }
            return true;
    }
    public boolean isPalindrome(String s, int leftIndex, int rightIndex){
         while (rightIndex > leftIndex){
             if(s.charAt(rightIndex) != s.charAt(leftIndex)) return false;
              rightIndex --;
                leftIndex ++;
         }
         return true;
    }
}