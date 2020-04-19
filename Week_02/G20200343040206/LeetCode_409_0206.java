
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
//假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_409_0206 {
    //1. 取所有字符串的最大偶数次数
    //2. 如果有奇数个字符串，则可以+1
    public int longestPalindrome(String s) {
        if (s==null) return 0;
        if (s.length()==1)return 1;
        int result = 0;
        //26+26+不连续的中间6个
        int[] num = new int[58];
        for (char c : s.toCharArray()) {
            num[c - 'A']++;
        }
        for (int i : num) {
            result += i - (i & 1);
            if ((i & 1) ==1 && (result & 1) == 0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_409_0206 source = new LeetCode_409_0206();
        System.out.println(source.longestPalindrome("abccccdd"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
