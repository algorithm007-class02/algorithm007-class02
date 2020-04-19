class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> start = new HashSet<>();
        start.add(beginWord);
        HashSet<String> end = new HashSet<>();
        end.add(endWord);
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        return deBfs(start, end, words, 2);
    }

    private int deBfs(HashSet<String> start, HashSet<String> end, HashSet<String> words, int depth) {

        if (start.size() > end.size()) {
            return deBfs(end, start, words, depth);
        }
        words.removeAll(start);
        HashSet<String> next = new HashSet<>();
        for (String str : start) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String word = new String(chars);
                    if (words.contains(word)) {
                        if (end.contains(word)) {
                            return depth;
                        }
                        next.add(word);
                    }
                }
                chars[i] = temp;
            }
        }
        if (start.isEmpty()) {
            return 0;
        }
        return deBfs(next, end, words, depth + 1);

    }
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord))
//            return 0;
//
//        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//
//        int res = 0;
//        while (!queue.isEmpty()) {
//            res++;
//            for (int i = 0; i < queue.size(); i++) {
//                String start = queue.poll();
//                for (String string : wordList) {
//                    if (visited.contains(string)) {
//                        continue;
//                    }
//                    if (!progress(start, string)) {
//                        continue;
//                    }
//                    if (string.equals(endWord)) {
//                        return res + 1;
//                    }
//                    visited.add(string);
//                    queue.offer(string);
//                }
//            }
//        }
//        return 0;
//    }
//    private boolean progress(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                count++;
//                if (count > 1) {
//                    return false;
//                }
//            }
//        }
//        return count == 1;
//    }
}