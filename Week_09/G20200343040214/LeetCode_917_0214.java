class Solution {
    private static boolean isLetter(char da) {
        if ((da >= 'A' && da <= 'Z') || (da >= 'a' && da <= 'z')) {
            return true;
        }
        return false;
    }

    public String reverseOnlyLetters(String S) {
        char[] data = S.toCharArray();
        int[] indexArr = new int[data.length];
        int pre = 0, post = 0;
        for (int i = 0; i < data.length; i++) {
            char datum = data[i];
            if (isLetter(datum)) {
                indexArr[post++] = i;
            }
        }
        post -= 1;
        while (pre < post) {
            int preIndex = indexArr[pre++];
            int postIndex = indexArr[post--];
            data[preIndex] = (char) (data[preIndex] ^ data[postIndex]);
            data[postIndex] = (char) (data[postIndex] ^ data[preIndex]);
            data[preIndex] = (char) (data[preIndex] ^ data[postIndex]);
        }
        return new String(data);
    }
}