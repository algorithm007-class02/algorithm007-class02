public boolean validPalindrome(String s) {
    for(int i = 0, j = s.length()-1; i < j ; i++, j--){
        if(s.charAt(i) != s.charAt(j)){
            //分两种情况，一是右边减一，二是左边加一
            return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
        }
    }
    return true;
}

public boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
        if (s.charAt(i++) != s.charAt(j--)) {
            return false;
        }
    }
    return true;
}
