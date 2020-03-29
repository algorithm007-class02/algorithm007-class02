import java.util.Map;
//有效的括号
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }};

        public boolean isValid(String s) {
            if(s.length()>0  && !map.containsKey(s.charAt(0)))  return false;
            LinkedList<Character> list = new LinkedList<Character>();
            list.add('?');

            for (char c : s.toCharArray()) {
                if(map.containsKey(c)){
                    list.addLast(c);
                }else if(map.get(list.removeLast()) !=c){
                    return false;
                }
            }
            return list.size()==1;
        }
    }