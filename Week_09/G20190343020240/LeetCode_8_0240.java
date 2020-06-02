class Solution {
    public int myAtoi(String str) {
        //1、找到第一个非空字符
        //2、判断时候是否为正负号
        //3、找出连续数字，并将其转换为10进制
        //4、判断10进制是否越界
        char[] strChar = str.toCharArray();
        int len = str.length();
        int index = 0,sign = 1;
        long num = 0;
        while(index < len && strChar[index] == ' '){
            index++;
        }
        if(index == len) return 0;
        if(strChar[index] == '+'){
            index++;
        }else if(strChar[index] == '-'){
            index++;
            sign = -1;
        }
        while(index < len && (strChar[index] >= '0' && strChar[index] <= '9')){
            num = num * 10 + (strChar[index] - '0');
            if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;
        }
        return (int)(sign * num);
    }
}