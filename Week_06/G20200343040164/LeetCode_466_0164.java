//由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 
//
// 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得
//，但不能从 “acbbe” 获得。 
//
// 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S
//1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。 
//
// 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。 
//
// 
//
// 示例： 
//
// 输入：
//s1 ="acb",n1 = 4
//s2 ="ab",n2 = 2
//
//返回：
//2
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.length() == 0 || s2.length() == 0 || n1 == 0 || n2 == 0) return 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int count = 0;
        int index = 0;
        int[] indexr = new int[s2Chars.length + 1];
        int[] countr = new int[s2Chars.length + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1Chars.length; j++) {
                if (s1Chars[j] == s2Chars[index]) {
                    if (index == s2Chars.length - 1) {
                        count++;
                        index = 0;
                    } else index++;
                }
            }
            countr[i] = count;
            indexr[i] = index;
            for (int k = 0;k < i && indexr[k] == index; k++) {
                int pre_count = countr[k];
                int pattern_count = ((n1 - 1 - k) / (i - k)) * (countr[i] - countr[k]);
                int remain_count = countr[k + (n1 - 1 - k) % (i - k)] - countr[k];
                return (pre_count + pattern_count + remain_count) / n2;
            }
        }
        return countr[n1 - 1] / n2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
