package level2;

import java.util.*;

public class Solution127 {
    static class Pair<S, M> {
        private S key;
        private M value;

        public Pair(S key, M value) {
            this.key = key;
            this.value = value;
        }

        public S getKey() {
            return key;
        }

        public void setKey(S key) {
            this.key = key;
        }

        public M getValue() {
            return value;
        }

        public void setValue(M value) {
            this.value = value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> ts = map.getOrDefault(newWord, new ArrayList<>());
                ts.add(word);
                map.put(newWord, ts);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                // beginWord 的每种可能的变换方式 找到对应变换方式在 字典中可能的单词
                // 如果这个单词等于 最后的单词 则变换结束
                // 否则把这个单词加入队列在进行后续相同的操作，但对于已经做过
                // 同样变换的单词要排除掉
                List<String> fits = map.getOrDefault(newWord, new ArrayList<>());
                for (String s : fits) {
                    if (s.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(s)) {
                        visited.put(s, true);
                        queue.add(new Pair<>(s, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
