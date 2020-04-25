public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        int n=3;
        List<String> strings = generateParenthesis(n);
        System.out.println(strings);
    }
    private static List<String> generateParenthesis(int n) {
        return generate(n);
    }

    private static List<String> generate(int n) {
        ArrayList[] cache = new ArrayList[100];
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generate(c))
                    for (String right: generate(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }
}