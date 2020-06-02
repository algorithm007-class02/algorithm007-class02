class Solution {
    //分割+反转利用javaAPI
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    //分割+反转
    public String reverseWords1(String s) {
        String[] arrs = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (String str : arrs) {
            String ss = reserve(str);
            sb.append(ss + " ");
        }
        return sb.toString().trim();
    }

    private String reserve(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return String.copyValueOf(chars);
    }
}