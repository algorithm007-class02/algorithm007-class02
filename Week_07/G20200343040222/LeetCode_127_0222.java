public class LeetCode_127_0222 {

    /**
     * BFS 广度优先 时间复杂度为O(M * N) M为字符长度 N为wordList 大小
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String start, String end) {
        if (start.length() != end.length()) return false;
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    /**
     * 双向BFS  时间复杂度为O(M * N) M为字符长度 N为wordList 大小
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthRe(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        boolean[] visited = new boolean[wordList.size()];
        boolean[] visited2 = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) {
            visited[index] = true;
        }
        int index2 = wordList.indexOf(endWord);
        visited2[index2] = true;
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue.offer(beginWord);
        queue2.offer(endWord);
        int count = 0;
        while (!queue.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue.size() > queue2.size()) {
                Queue<String> temp = queue;
                queue = queue2;
                queue2 = temp;
                boolean[] tempV = visited;
                visited = visited2;
                visited2 = tempV;
            }
            int size = queue.size();
            for (int queueIndex = 0; queueIndex < size; queueIndex++) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (visited2[i]) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }

        }
        return 0;
    }

    /**
     * 双向BFS 优化匹配字符串
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthRe(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        int index = wordList.indexOf(beginWord);
        if (index != -1) {
            visited.add(wordList.get(index));
        }
        visited2.add(endWord);
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue.offer(beginWord);
        queue2.offer(endWord);
        Set<String> allSet = new HashSet<>(wordList);
        int count = 0;
        while (!queue.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue.size() > queue2.size()) {
                Queue<String> temp = queue;
                queue = queue2;
                queue2 = temp;
                Set<String> tempV = visited;
                visited = visited2;
                visited2 = tempV;
            }
            int size = queue.size();
            for (int queueIndex = 0; queueIndex < size; queueIndex++) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    for (char a = 'a'; a <= 'z'; a++) {
                        chars[i] = a;
                        String newString = new String(chars);
                        if (visited.contains(newString)) {
                            continue;
                        }
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        if (allSet.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                    chars[i] = ch;
                }
            }

        }
        return 0;
    }
}