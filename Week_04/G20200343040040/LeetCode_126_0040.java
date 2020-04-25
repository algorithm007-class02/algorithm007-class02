int min = 0;
public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    //如果不含有结束单词，直接结束，不然后边会造成死循环
    if (!wordList.contains(endWord)) {
        return ans;
    }
    //利用 BFS 得到所有的邻居节点
    HashMap<String, ArrayList<String>> map = bfs(beginWord, endWord, wordList);
    ArrayList<String> temp = new ArrayList<String>();
    // temp 用来保存当前的路径
    temp.add(beginWord);
    findLaddersHelper(beginWord, endWord, map, temp, ans);
    return ans;
}

private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                               ArrayList<String> temp, List<List<String>> ans) {
    if (beginWord.equals(endWord)) {
        ans.add(new ArrayList<String>(temp));

        return;
    }
    if(temp.size() - 1==  min){
        return;
    }
    // 得到所有的下一个的节点
    ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
    for (String neighbor : neighbors) {
        if (temp.contains(neighbor)) {
            continue;
        }
        temp.add(neighbor);
        findLaddersHelper(neighbor, endWord, map, temp, ans);
        temp.remove(temp.size() - 1);
    }
}

public HashMap<String, ArrayList<String>> bfs(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    boolean isFound = false;

    Set<String> dict = new HashSet<>(wordList);
    while (!queue.isEmpty()) {
        int size = queue.size();
        min++;
        for (int j = 0; j < size; j++) {
            String temp = queue.poll();
            // 一次性得到所有的下一个的节点
            ArrayList<String> neighbors = getNeighbors(temp, dict);
            map.put(temp, neighbors);
            for (String neighbor : neighbors) {
                if (neighbor.equals(endWord)) {
                    isFound = true;
                }
                queue.offer(neighbor);
            }
        }
        if (isFound) {
            break;
        }
    }
    return map;
}
private ArrayList<String> getNeighbors(String node, Set<String> dict) {
    ArrayList<String> res = new ArrayList<String>();
    char chs[] = node.toCharArray();

    for (char ch = 'a'; ch <= 'z'; ch++) {
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ch)
                continue;
            char old_ch = chs[i];
            chs[i] = ch;
            if (dict.contains(String.valueOf(chs))) {
                res.add(String.valueOf(chs));
            }
            chs[i] = old_ch;
        }

    }
    return res;
}
