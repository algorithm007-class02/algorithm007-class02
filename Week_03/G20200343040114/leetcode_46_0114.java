import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 46. 全排列
// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

// 示例:

// 输入: [1,2,3]
// 输出:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    private List<List<Integer>> output = new ArrayList<>();
    int k;
    
    public List<List<Integer>> permute(int[] nums) {
        this.k = nums.length;
        backTrace(new LinkedList<>(), nums);
        return output;
    }

    private void backTrace(LinkedList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));

        }
        for (int i = 0; i < k; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                backTrace(curr, nums);
                curr.removeLast();
            }
        }
    }
   
}

// class Solution {
//   public void backtrack(int n,
//                         ArrayList<Integer> nums,
//                         List<List<Integer>> output,
//                         int first) {
//     // if all integers are used up
//     if (first == n)
//       output.add(new ArrayList<Integer>(nums));
//     for (int i = first; i < n; i++) {
//       // place i-th integer first 
//       // in the current permutation
//       Collections.swap(nums, first, i);
//       // use next integers to complete the permutations
//       backtrack(n, nums, output, first + 1);
//       // backtrack
//       Collections.swap(nums, first, i);
//     }
//   }

//   public List<List<Integer>> permute(int[] nums) {
//     // init output list
//     List<List<Integer>> output = new LinkedList();

//     // convert nums into list since the output is a list of lists
//     ArrayList<Integer> nums_lst = new ArrayList<Integer>();
//     for (int num : nums)
//       nums_lst.add(num);

//     int n = nums.length;
//     backtrack(n, nums_lst, output, 0);
//     return output;
//   }
// }

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// }