public class LeetCode_541_0222 {

    /**
     * 双指针 时间复杂度为O(N) 空间复杂度为O(1) N为s长度
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += k) {
            if (i%(2*k)==0){
                if (i+k-1<ch.length) {
                    for (int j = 0; j < k / 2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[i+k-1-j];
                        ch[i+k-1-j]=mid;
                    }
                }
                else{
                    for (int j = 0; j < (ch.length-i)/2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[ch.length-1-j];
                        ch[ch.length-1-j]=mid;
                    }
                }
            }
        }
        return new String(ch);
    }
}