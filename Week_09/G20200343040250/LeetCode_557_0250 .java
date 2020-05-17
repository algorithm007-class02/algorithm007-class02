class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        int len = strArr.length;

        for (int i = 0; i < len; i++) {
            strArr[i] = reverse(strArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                sb.append(strArr[i]);
            } else {
                sb.append(strArr[i]).append(" ");
            }
        }
        return sb.toString();
    }

    private String reverse(String s) {
        char[] chArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char temp = chArr[left];
            chArr[left++] = chArr[right];
            chArr[right--] = temp;
        }
        return new String(chArr);
    }
}