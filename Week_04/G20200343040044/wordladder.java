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

        return deBfs(start,end,words,2);
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
}