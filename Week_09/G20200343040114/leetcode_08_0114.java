import java.util.HashMap;
import java.util.Map;

class Solution {

    class Automaton {
        final String START = "start";
        final String SIGNED = "signed";
        final String IN_NUM = "in_number";
        final String END = "end";
        String state = START;
        Map<String, String[]> map;
        public int sign = 1;
        public long ans = 0;

        public Automaton() {
            map = new HashMap<>();
            map.put(START, new String[] { START, SIGNED, IN_NUM, END });
            map.put(SIGNED, new String[] { END, END, IN_NUM, END });
            map.put(IN_NUM, new String[] { END, END, IN_NUM, END });
            map.put(END, new String[] { END, END, END, END });
        }

        public int get_col(char c) {
            if (c == ' ')
                return 0;
            if (c == '+' || c == '-')
                return 1;
            if (c >= '0' && c <= '9')
                return 2;
            return 3;
        }

        public void get(char c) {
            state = map.get(state)[get_col(c)];
            if (state.equals(IN_NUM)) {
                ans = ans * 10 + c - '0';
                if (sign == 1) {
                    ans = Math.min(ans, Integer.MAX_VALUE);
                } else {
                    // -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
                    ans = Math.min(ans, -(long) Integer.MIN_VALUE);
                }
            } else if (state.equals(SIGNED))
                sign = c == '+' ? 1 : -1;
        }
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        char[] c = str.toCharArray();
        for (char ch : c) {
            automaton.get(ch);
        }
        return automaton.sign * ((int) automaton.ans);
    }
}