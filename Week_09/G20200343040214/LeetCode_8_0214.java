class Solution {

    public static int myAtoi(String str) {

        if (str == null || "".equals(str)) {
            return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        int[] eles = new int[str.length()];
        for (int k = 0; k < str.length(); k++) {
            eles[k] = (int) str.charAt(k);
        }

        if ((eles[0] < 48 || eles[0] > 57) && eles[0] != '+' && eles[0] != '-' && eles[0] != ' ') {
            return 0;
        }
        int i = 0;
        boolean negtive = false;
        int n = eles.length;
        LinkedList<Integer> stack = new LinkedList<>();
        while (i < n) {
            if (i == 0) {
                if (eles[0] == '-') {
                    negtive = true;
                } else {
                    negtive = false;
                    if (eles[0] != '+') {
                        stack.add(eles[0] - 48);
                    }
                }
            } else {
                if (eles[i] >= 48 && eles[i] <= 57) {
                    stack.push(eles[i] - 48);
                } else {
                    break;
                }
            }
            i += 1;
        }
        int sum = 0;
        for (int j = stack.size() - 1; j >= 0; j--) {
            // -2147483648
            // 214748364742
            if (negtive) {
                if (sum > Math.abs(Integer.MIN_VALUE + 1) / 10
                        || (sum == Math.abs(Integer.MIN_VALUE + 1) / 10 && stack.get(j) >= 8)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (sum > Integer.MAX_VALUE / 10 || (sum == Math.abs(Integer.MAX_VALUE) / 10 && stack.get(j) >= 7)) {
                    return Integer.MAX_VALUE;
                }
            }
            sum = sum * 10 + stack.get(j);
        }

        return negtive ? -1 * sum : sum;
    }
}