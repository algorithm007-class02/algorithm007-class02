
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_14_0206 {
    /**
     * 暴力循环：找到最短单词，按照字母遍历
     * 生成一个Trie树，找公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
           return "";
       }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return "";
            }
        }
        return ans;
    }

    //分治
    public String longestCommonPrefix_2(String[] strs) {
        //结束条件
        //处理当前数据
        //拆分子问题
        //合并子问题的结果
        //恢复当前层变量状态
        if (strs == null || strs.length == 0) {
            return "";
        }
        return divideConquer(strs, 0, strs.length - 1);


    }

    private String divideConquer(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }

        int mid = left + (right - left) / 2;
        String lcpLeft = divideConquer(strs, left, mid);
        String lcpRight = divideConquer(strs, mid + 1, right);

        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int i = 0;
        for (; i < lcpLeft.length() && i < lcpRight.length() ; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                break;
            }
        }
        return lcpLeft.substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
