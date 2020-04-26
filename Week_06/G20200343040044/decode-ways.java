package 第五周;

class Solution {
    public int numDecodings(String s) {
    if(s.length() == 0) return 0;
    int pre = 27, digit, answer = 0, first = 1, second = 1;
    for(int i = s.length()-1; i >= 0; i--){
        digit = s.charAt(i) - '0';
        if(digit == 0) answer = 0;
        else answer = first + (digit*10 + pre < 27 ? second : 0);
        second = first; first = answer; pre = digit;
    }
    return answer;
    }
}