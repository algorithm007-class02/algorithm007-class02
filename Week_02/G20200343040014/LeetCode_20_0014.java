class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 > 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char e: s.toCharArray()){
            if (e == '('){
                stack.push(')');
            }else if (e == '{'){
                stack.push('}');
            }else if (e == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty()||e != stack.pop()){
                    return false;
                }
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}