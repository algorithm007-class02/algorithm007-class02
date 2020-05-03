package week07.g20200343040172;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_127_0172 {

    /**
     * BFS-1
     */
    class Solution1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            // Since all words are of same length.
            int L = beginWord.length();

            // Dictionary to hold combination of words that can be formed,
            // from any given word. By changing one letter at a time.
            Map<String, List<String>> allComboDict = new HashMap<>();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            // Key is the generic word
                            // Value is a list of words which have the same intermediate generic word.
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                            transformations.add(word);
                            allComboDict.put(newWord, transformations);
                        }
                    });

            // Queue for BFS
            Queue<Pair<String, Integer>> Q = new LinkedList<>();
            Q.add(new Pair(beginWord, 1));

            // Visited to make sure we don't repeat processing same word.
            Map<String, Boolean> visited = new HashMap<>();
            visited.put(beginWord, true);

            while (!Q.isEmpty()) {
                Pair<String, Integer> node = Q.remove();
                String word = node.getKey();
                int level = node.getValue();
                for (int i = 0; i < L; i++) {

                    // Intermediate words for current word
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                    // Next states are all the words which share the same intermediate state.
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                        // If at any point if we find what we are looking for
                        // i.e. the end word - we can return with the answer.
                        if (adjacentWord.equals(endWord)) {
                            return level + 1;
                        }
                        // Otherwise, add it to the BFS Queue. Also mark it visited
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            Q.add(new Pair(adjacentWord, level + 1));
                        }
                    }
                }
            }

            return 0;
        }
    }

    /**
     * BFS-2
     */
    class Solution2 {

        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

            int len = 1;
            int strLen = beginWord.length();
            HashSet<String> visited = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> set = beginSet;
                    beginSet = endSet;
                    endSet = set;
                }

                Set<String> temp = new HashSet<>();
                for (String word : beginSet) {
                    char[] chs = word.toCharArray();

                    for (int i = 0; i < chs.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = chs[i];
                            chs[i] = c;
                            String target = String.valueOf(chs);

                            if (endSet.contains(target)) {
                                return len + 1;
                            }

                            if (!visited.contains(target) && wordList.contains(target)) {
                                temp.add(target);
                                visited.add(target);
                            }
                            chs[i] = old;
                        }
                    }
                }

                beginSet = temp;
                len++;
            }

            return 0;
        }
    }

}
