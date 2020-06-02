import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    //利用javaAPI
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    //分割+倒序添加
    public String reverseWords2(String s){
        String[] arr = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = arr.length - 1;i >= 0;i--){
            if(arr[i].equals(" ")) continue;
            sb.append(arr[i]+" ");
        }
        return sb.toString().trim();
    }
}