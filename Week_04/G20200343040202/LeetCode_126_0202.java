class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<>();
        // Set.contains()方法时间复杂度 O(1)
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return resList;
        // 正向DFS
        Set<String> positiveSet = new HashSet<>();
        // 加入起点
        positiveSet.add(beginWord);
        //反向DFS
        Set<String> oppositeSet = new HashSet<>();
        // 加入终点
        oppositeSet.add(endWord);
        // 构造整个映射树
        HashMap<String, List<String>> mapTree = new HashMap<>();
        // buildMapTree只有在找到最短路径时(从上往下，从下往上相遇)才会返回true
        if (buildMapTree(mapTree, true, wordSet, positiveSet, oppositeSet)) {
            // dfs获得结果
            dfs(mapTree, resList, beginWord, endWord, new ArrayList<>());
        }
        return resList;
    }

    /**
     * 我们总会选择需要扩展的节点数少的方向作为正方形进行扩展，所以当正向需要扩展的节点集空，直接返回
     * 或者，正向扩展的出下一层节点中的某个节点已出现在反向已访问集合中，搜索树构建完毕
     *
     * @param wordsSet
     * @param positiveSet
     * @param oppositeSet
     * @param direction
     * @return
     */
    private boolean buildMapTree(HashMap<String, List<String>> mapTree, boolean direction, Set<String> wordsSet, Set<String> positiveSet, Set<String> oppositeSet) {
        if (positiveSet.size() == 0)
            return false;
        // 调整扩展方向
        if (oppositeSet.size() < positiveSet.size())
            return buildMapTree(mapTree, !direction, wordsSet, oppositeSet, positiveSet);
        // 从全部集合中移除正向已访问过的节点
        wordsSet.removeAll(positiveSet);
        // 映射树是否构建完毕
        boolean isOK = false;
        // 记录本层扩展出的下一层全部节点
        Set<String> nextLevelSet = new HashSet<>();
        // 逐个取出本层节点，向下扩展
        for (String curWord : positiveSet) {
            // 找出这个单词能一次转换出哪些单词
            List<String> nearWordList = getNearWordList(curWord, wordsSet);
            // 逐个进行处理
            for (String nearWord : nearWordList) {
                // 加入下一层节点
                nextLevelSet.add(nearWord);
                // 根据扩展方向，调整键值，整个树最终是从上到下映射的
                String key = direction ? curWord : nearWord;
                String val = direction ? nearWord : curWord;
                // 判断是否构建完成(从上到下和从下到上都访问到这个节点)
                if (oppositeSet.contains(nearWord)) {
                    isOK = true;
                }
                // 把这个映射关系添加进映射树
                List<String> list = mapTree.getOrDefault(key, new ArrayList<>());
                list.add(val);
                mapTree.put(key, list);
            }
        }
        // if (isOK)
        //     return true;
        // 把扩展出的下一层作为待扩展节点集进行正向扩展
        // return buildMapTree(mapTree, direction, wordsSet, nextLevelSet, oppositeSet);
        //一般情况下新扩展的元素会多一些，所以我们下次反方向扩展，就可以减少调整方向的次数
        return isOK || buildMapTree(mapTree, !direction, wordsSet, oppositeSet, nextLevelSet);
    }

    /**
     * 根据构建好的映射树，找到从起点到终点的所有路径
     *
     * @param mapTree
     * @param resList
     * @param beginWord
     * @param endWord
     * @param tempPath
     */
    private void dfs(HashMap<String, List<String>> mapTree, List<List<String>> resList, String beginWord, String endWord, ArrayList<String> tempPath) {
        // 当前起点加入路径
        tempPath.add(beginWord);
        // 到达了目标
        if (beginWord.equals(endWord)) {
            // 当前路径作为一个结果加入结果集
            resList.add(new ArrayList<>(tempPath));
            tempPath.remove(tempPath.size() - 1);
            return;
        }
        // 没有到终点，但当前节点存在映射到下一层节点
        if (mapTree.containsKey(beginWord)) {
            for (String nearWord : mapTree.get(beginWord)) {
                // 下一层节点作为起点，继续dfs
                dfs(mapTree, resList, nearWord, endWord, tempPath);
            }
        }
        tempPath.remove(tempPath.size() - 1);
    }
    private List<String> getNearWordList(String word, Set<String> wordsSet) {
        ArrayList<String> resList = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old)
                    continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordsSet.contains(newWord))
                    resList.add(newWord);
            }
            // 把单词复原，下一次改变下一位置字符
            chars[i] = old;
        }
        return resList;
    }
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        // 结果集
//        List<List<String>> res = new ArrayList<>();
//        Set<String> distSet = new HashSet<>(wordList);
//        // 字典中不包含目标单词
//        if (!distSet.contains(endWord)) {
//            return res;
//        }
//        // 已经访问过的单词集合：只找最短路径，所以之前出现过的单词不用出现在下一层
//        Set<String> visited = new HashSet<>();
//        // 累积每一层的结果队列
//        Queue<List<String>> queue = new LinkedList<>();
//        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
//        queue.add(list);
//        visited.add(beginWord);
//        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
//        boolean flag = false;
//        while (!queue.isEmpty() && !flag) {
//            int size = queue.size();
//            // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
//            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
//            // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
//            Set<String> subVisited = new HashSet<>();
//            for (int i = 0; i < size; i++) {
//                List<String> path = queue.poll();
//                // 获取该路径上一层的单词
//                String word = path.get(path.size() - 1);
//                char[] chars = word.toCharArray();
//                // 寻找该单词的下一个符合条件的单词
//                for (int j = 0; j < chars.length; j++) {
//                    char temp = chars[j];
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        chars[j] = ch;
//                        if (temp == ch) {
//                            continue;
//                        }
//                        String str = new String(chars);
//                        // 符合条件：在 wordList 中 && 之前的层没有使用过
//                        if (distSet.contains(str) && !visited.contains(str)) {
//                            // 生成新的路径
//                            List<String> pathList = new ArrayList<>(path);
//                            pathList.add(str);
//                            // 如果该单词是目标单词：将该路径添加到结果集中，查询截止到该层
//                            if (str.equals(endWord)) {
//                                flag = true;
//                                res.add(pathList);
//                            }
//                            // 将该路径添加到该层队列中
//                            queue.add(pathList);
//                            // 将该单词添加到该层已访问的单词集合中
//                            subVisited.add(str);
//                        }
//                    }
//                    chars[j] = temp;
//                }
//            }
//            // 将该层所有访问的单词添加到总的已访问集合中
//            visited.addAll(subVisited);
//        }
//        return res;
//    }
}