class Solution {

    public int hammingWeight1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        int bit = 1;
        for(int  i = 0;i < 32;i++){
            if((n & bit) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}