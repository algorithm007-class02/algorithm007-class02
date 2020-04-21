class Solution {

    /**
     * BFS
     * 时间复杂度：O(N*L) N=wordList.length()  L=beginWord.length()
     * 空间复杂度：O(N*L)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> allMap = new HashMap<>();

        /**
         * 处理单词列表，将通用状态一样的数据归类
         * 例如： *ot -> {hot,lot...}
         *       o*t -> {oht,olt...}
         *       ot* -> {oth,otl...}
         */
        wordList.forEach(word -> {
            for (int i = 0; i < len; ++i) {
                String newStr = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> list = allMap.getOrDefault(newStr, new ArrayList<String>());
                list.add(word);
                allMap.put(newStr, list);
            }
        });

        //BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));
        //已访问数据集合，以免重复访问形成循环
        Set<String> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> cur = queue.poll();
            String word = cur.getKey();
            for (int i = 0; i < len; ++i) {
                String newStr = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> list = allMap.get(newStr);
                if (list == null) continue;
                for (String s : list) {
                    if (s.equals(endWord)) {
                        return cur.getValue() + 1;
                    }
                    if (!set.contains(s)) {
                        queue.add(new Pair<>(s, cur.getValue() + 1));
                        set.add(s);
                    }
                }
            }
        }
        return 0;
    }
}