package com.leetcode.search;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class L127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null ||
                wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Set<String> visited = new HashSet<>();
        boolean[] visited = new boolean[wordList.size()];
        List<String> arrayWordList = new ArrayList<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                log.info("current: {}", current);

                for (int j = 0; j < wordList.size(); j++) {
                    String candiate = arrayWordList.get(j);
                    if (visited[j]) {
                        continue;
                    }

                    if (!canConvert(current, candiate)) {
                        log.info("can not conver: {}, {}", current, candiate);
                        continue;
                    }

                    if (endWord.equals(candiate)) {
                        return step + 1;
                    }

                    visited[j] = true;
                    queue.offer(candiate);
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String current, String candiate) {
        assert current != null;
        assert candiate != null;
        if (current.length() != candiate.length()) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != candiate.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
