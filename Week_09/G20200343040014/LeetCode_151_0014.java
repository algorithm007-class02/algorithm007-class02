class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() -1 ;
        while (left <= right && s.substring(left,left +1).equals(" ")) left ++;
        while (left <= right && s.substring(right,right +1).equals(" ")) right --;
        s = s.substring (left,right+1);
        if(s.length() <= 1) return s;
        int startIndex = -1;
        int endIndex = -1;
        String res = new String();
        for (int i = 0; i < s.length(); i++) {
            if (endIndex >= 0) {
                String newString = s.substring(startIndex, endIndex);
                if (res.length() == 0){
                    res = newString;
                }else
                {
                    res = newString + " " + res;
                }
                endIndex = -1;
                startIndex = -1;
            }
            String sub = s.substring(i,i+1);
            if (!sub.equals(" ")) {
                if (startIndex < 0) {
                    startIndex = i;
                }
                if (i == s.length() - 1) {
                    String newString = s.substring(startIndex, i+1);
                    if (res.length() == 0){
                        res = newString;
                    }else
                    {
                        res = newString + " " + res;
                    }
                }
            }else 
            {
                if (startIndex >= 0) {
                    endIndex = i;
                }
            }
        }
        return res;
    }
}