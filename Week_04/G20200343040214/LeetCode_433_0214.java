package level2;

import java.util.*;

public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        char[] ACGT = new char[] { 'A', 'C', 'G', 'T' };
        Set<String> visited = new HashSet<>();
        Set<String> banks = new HashSet<>(Arrays.asList(bank));
        Queue<String> open = new LinkedList<>();
        open.offer(start);
        int depth = 0;
        while (!open.isEmpty()) {
            Queue<String> layer = open;
            open = new LinkedList<>();
            while (!layer.isEmpty()) {
                String next = layer.poll();
                visited.add(next);
                char[] chars = next.toCharArray();
                // 通过 start 字符串 和 A C G T 组合不同的变换序列
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    for (char n : ACGT) {
                        // 在第 i 位有 4中替换规则，字母相等时不必替换
                        if (c != n) {
                            chars[i] = n;
                            String s = new String(chars);
                            if (!visited.contains(s) && banks.contains(s)) {
                                if (s.equals(end)) {
                                    return depth + 1;
                                }
                                open.offer(s);
                            }
                        }
                    }
                    chars[i] = c;
                }
            }
            depth += 1;
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] charSet = new char[] { 'A', 'C', 'G', 'T' };
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                visited.add(curr);
                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        if (old != c) {
                            currArray[i] = c;
                            String next = new String(currArray);
                            if (!visited.contains(next) && bankSet.contains(next)) {
                                if (next.equals(end)) {
                                    return level + 1;
                                }
                                queue.offer(next);
                            }
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
