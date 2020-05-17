//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution709 {
    /*练手*/
    public String toLowerCase(String str){
        StringBuilder ans = new StringBuilder(str.length());
        for (char c: str.toCharArray()){
            if (c>=65 && c<=90){
                c+=32;
            }
            ans.append(c);
        }
        return ans.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

//    public String toLowerCase(String str) {
//        StringBuilder ans = new StringBuilder(str.length());
//        for(char c: str.toCharArray()){
//            if (c>=65 && c<=90){
//                c+=32;
//            }
//            ans.append(c);
//        }
//        return ans.toString();
//    }
/*
 * 耗时0ms（100%），使用内存37.4M（6%）*/

