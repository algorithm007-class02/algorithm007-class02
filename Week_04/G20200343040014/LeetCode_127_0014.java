class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 生成通用单词表，用哈希表存储
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : wordList) {
            for (int i = 0; i < str.length(); i++) {
                String newString = str.substring(0, i) + '*' + str.substring(i + 1, str.length());
                ArrayList<String> list = map.get(newString);
                if (list == null) {
                    list = new ArrayList<String>();
                    map.put(newString, list);
                }
                list.add(str);
            }
        }
        return findWord(beginWord, endWord,map);
    }
    public int findWord (String beginWord, String endWord,HashMap<String, ArrayList<String>> map){
        // 1. 创建队列，利用先进先出特性，BFS遍历n叉树
            Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
            Q.add(new Pair(beginWord, 1));
            HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
            visited.put(beginWord, true);
            while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < word.length(); i++) {
        // 2. 生成单词的的通配词，再从对应的map表中遍历对应的数组。
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                for (String adjacentWord : map.getOrDefault(newWord, new ArrayList<String>())) {
        // 3. 从数组中匹配endWord。
                if (adjacentWord.equals(endWord)) {
                    return level + 1;
                }
        // 4. 为了避免重复单词在队列中造成死循环，需要visited数组记录是否被访问过
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