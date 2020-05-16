package Week_09.G20200343040246;

public class LeetCode_8_0246 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_8_0246().myAtoi("  -42"));
    }
    
    public int myAtoi(String str) {
        boolean started = false;
        int val = 0;
        int neg = -1;
        int maxVal = -Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c < '0' || c > '9') && c != '-' && c != '+' && c != ' ') {
                break;
            }

            if(!started && (c == '-' || c == '+' || c == ' ')){
                if(c != ' '){
                    started = true;
                }
                if(c == '-'){
                    maxVal = Integer.MIN_VALUE;
                    neg = 1;
                }
                continue;
            }
            if(c == '-' || c == '+' || c == ' '){
                break;
            }
            if(val < maxVal / 10 || val * 10 < maxVal + (str.charAt(i) - '0')){
                return neg * maxVal;
            }
            val = val * 10 - (str.charAt(i) - '0');
            started = true;
        }
        return neg * val;
    }
}