public class OnlyLetters917 {
    public static void main(String[] args) {
        String s = "ab-cd";
        String res = reverseOnlyLetters(s);
        System.out.println(res);
    }

    private static String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}