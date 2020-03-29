package G20200343040320;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution242 {
    public boolean isAnagram(String s, String t) {
        return Math.abs(sumChar(s) - sumChar(t)) < 0.0001;
    }
    //查看数字加起来起来是否一样 抄别人的。
    public double sumChar(String s){
        double sum = 0;
        char[] cs = s.toCharArray();
        for(char c : cs){
            sum += Math.pow((int)c,0.5);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LeetCode_242_0320{

}
//leetcode submit region end(Prohibit modification and deletion)
