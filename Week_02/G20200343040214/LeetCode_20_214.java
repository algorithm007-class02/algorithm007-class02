class Solution20 {
    public static boolean isValid(String s) {
        Map<Character, Character> match = new HashMap<>();
        match.put(')', '(');
        match.put(']', '[');
        match.put('}', '{');
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ele = s.charAt(i);
            if (!stack.isEmpty() && match.containsKey(ele)) {
                char top = stack.peek();
                if (top != match.get(ele)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ele);
            }

        }
        return stack.isEmpty();
    }
}