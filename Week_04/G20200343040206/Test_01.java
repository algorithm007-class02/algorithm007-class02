import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//注意：
//
//答案中不可以包含重复的四元组。
//
//示例：
//
//给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
public class Test_01 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        int start = 0;
        int end = n-1;

        for (int i = start; i< n-3; ++i) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i+1; j<n-2;++j) {
                if (j > (i+1) && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = j+1;
                int l = n-1;

                while (k < l) {
                    if (k > (j+1) && nums[k] == nums[k-1]) {
                        k++;
                        continue;
                    }

                    if (l < (n-1) && nums[l] == nums[l+1]) {
                        l--;
                        continue;
                    }

                    int s = nums[i] +nums[j] + nums[k] + nums[l];
                    if (s == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    } else if (s < target) {
                        k++;
                    } else {
                        l--;
                    }

                }

            }


        }
       return result;
    }
}
