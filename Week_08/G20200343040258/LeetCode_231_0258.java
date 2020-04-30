class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        if( n == 1){
            return true;
        }
		int chushu = n;
		while(chushu % 2 == 0){
			chushu = chushu / 2;
		}
		return chushu == 1;
    }
}