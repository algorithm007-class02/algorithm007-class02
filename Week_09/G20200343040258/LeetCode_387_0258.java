class Solution {
    public int firstUniqChar(String s) {
        //用数组表示 对应acsii下标的数量
        int[] asciiChar = new int[257];
        int size = s.length();
        for(int i = 0; i < size; i++)
            asciiChar[s.charAt(i)]++;

        for(int i = 0; i < size; i++){
            if(asciiChar[s.charAt(i)] == 1)
                return i;
        }
            
        return -1;
    }
}