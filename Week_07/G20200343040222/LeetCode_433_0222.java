public class LeetCode_433_0222 {

    /**
     * DFS 时间复杂度为O(N* M) N为数组长度 M为字符串长度 空间复杂度为O(N)
     */
    private int stepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(), start, end, 0, bank);
        return stepCount == Integer.MAX_VALUE ? -1 : stepCount;
    }

    private void dfs(HashSet<String> path, String currentStr, String end, int step, String[] bank) {
        if (currentStr.equals(end)) {
            stepCount = Math.min(step, stepCount);
            return;
        }
        if (step >= stepCount) {
            return;
        }
        outter: for (String single : bank) {
            int diff = 0;
            for (int i = 0; i < single.length(); i++) {
                if (single.charAt(i) != currentStr.charAt(i)) {
                    if (++diff > 1) continue outter;
                }
            }
            if (diff == 1 && !path.contains(single)) {
                path.add(single);
                dfs(path, single, end, step + 1, bank);
                path.remove(single);
            }
        }

    }
    /**
     * BFS 时间复杂度为O(N* M) N为数组长度 M为字符串长度
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutationRe(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] basicChars = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                char[] currentChars = queue.poll().toCharArray();
                for (int i = 0; i < currentChars.length; i++) {
                    char ch = currentChars[i];
                    for (char basicCh : basicChars) {
                        currentChars[i] = basicCh;
                        String newString = new String(currentChars);
                        if (end.equals(newString)) {
                            return res;
                        }
                        if (visited.contains(newString)) {
                            continue;
                        }
                        if (set.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                    currentChars[i] = ch;
                }
            }

        }
        return -1;
    }

    /**
     * 双向BFS 时间复杂度为O(N* M) N为数组长度 M为字符串长度
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutationReRe(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] basicChars = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<String>();
        Queue<String> queue2 = new LinkedList<String>();
        queue.offer(start);
        queue2.offer(end);
        Set<String> visited = new HashSet<String>();
        Set<String> visited2 = new HashSet<String>();
        visited.add(start);
        visited2.add(end);
        int res = 0;
        while (!queue.isEmpty() && !queue2.isEmpty()) {
            if (queue.size() > queue2.size()) {
                Queue<String> tempQueue = queue;
                queue = queue2;
                queue2 = tempQueue;
                Set<String> tempVisited = visited;
                visited = visited2;
                visited2 = tempVisited;
            }
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                char[] currentChars = queue.poll().toCharArray();
                for (int i = 0; i < currentChars.length; i++) {
                    char ch = currentChars[i];
                    for (char basicCh : basicChars) {
                        currentChars[i] = basicCh;
                        String newString = new String(currentChars);
                        if (visited2.contains(newString)) {
                            return res + 1;
                        }
                        if (visited.contains(newString)) {
                            continue;
                        }
                        if (set.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                    currentChars[i] = ch;
                }
            }
            res++;

        }
        return -1;
    }

}