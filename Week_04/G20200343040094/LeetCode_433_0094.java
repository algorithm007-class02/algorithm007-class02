import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
// 1.BFS
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++){
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)){
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
// 2.DFS
class Solution {
    int minStep = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        backtrack(start, end, bank, 0, new HashSet<>());
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }
    private void backtrack(String start, String end, String[] bank, int step, Set<String> visited){
        if(start.intern() == end.intern()){
            minStep = Math.min(step, minStep);
        }
        for (String e: bank){
            int diff = 0;
            for(int i = 0; i < e.length(); i++){
                if(start.charAt(i) != e.charAt(i)){
                    diff++;
                    if(diff > 1) break;
                }
            }
            if(diff == 1 && !visited.contains(e)){
                visited.add(e);
                backtrack(e, end, bank, step+1, visited);
                visited.remove(e);
            }
        }
    }
}
// @lc code=end

