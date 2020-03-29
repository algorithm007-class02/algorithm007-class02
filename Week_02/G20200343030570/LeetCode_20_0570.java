import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap();

        map.put('{','}'); 
        map.put('[',']'); 
        map.put('(',')'); 

        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;

        LinkedList<Character> stack = new LinkedList<Character>();
        
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.addLast(c);
            // 栈空时，还有右括号
            else if (stack.size() == 0 || map.get(stack.removeLast()) != c)
                return false;
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isValid("{{()}}"));

    }
}