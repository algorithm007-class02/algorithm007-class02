//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if ( len == 0 ) return result;

        Arrays.sort(nums);

        boolean[] used = new boolean[len];

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums,len,0,used,path,result);
        return result;
    }
    public void dfs(int[] nums,int len,int depth,boolean[] used,Deque<Integer> path,List<List<Integer>> result) {
        if (len == depth) {
            result.add(new ArrayList<>(path));
            return;
        }
        for ( int i = 0; i < len; i++ ) {
            if (used[i]) continue;
            if ( i > 0 && nums[i] == nums[i-1] && !used[i-1] ) continue;

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums,len,depth+1,used,path,result);
            used[i] = false;
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
