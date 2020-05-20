//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution58 {
    /*再改进*/
    public int lengthOfLastWord(String s){
        int tail = s.length()-1;
        int ans = 0;
        if (s==null || s.length()==0) {return ans;}

        for (;tail>=0;tail--){
            if (s.charAt(tail)==' ') {
                if (ans==0) {continue;}
                else {break;} //可以不用else直接break
            }
            ans++;
        }
        return ans;
    }
    /*
     * 耗时0ms（100%），使用内存37.9M（6%）*/
}
//leetcode submit region end(Prohibit modification and deletion)

/*不使用trim，从后向前，先去括号，避免分类讨论
 * 两个循环还是太慢了*/
//    public int lengthOfLastWord(String s){
//        int tail = s.length()-1;
//        int ans=0;
//        //去掉结尾所有的空格
//        while (tail>=0 && s.toCharArray()[tail]==' ') {tail--;}
//        for (;tail>=0;tail--){
//            if (s.toCharArray()[tail]!=' '){
//                ans++;
//            } else {break;}
//        }
//        return ans;
//    }
/*
 * 耗时109ms（5%），使用内存40M（6%）*/

/*直接调用trim的好慢*/
//    public int lengthOfLastWord(String s) {
//       if (s==null || s.length()==0) {return 0;}
//       s=s.trim();
//       int length=0;
//       for (int tail = s.length()-1; tail>=0; tail--){
//            if (s.toCharArray()[tail]!=' '){
//                length++;
//            } else {
//                break;
//            }
//       }
//       return length;
//    }
    /*
     * 耗时9ms（5%），使用内存39.6M（6%）*/
