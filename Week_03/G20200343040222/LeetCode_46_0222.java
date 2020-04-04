/**
 * 全排列
 */
public class LeetCode_77_0222 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null){
            return res;
        }
        backTrck(nums, 0);
        return res;
    }

    private void backTrck(int[] nums, int i) {
        if(i >= nums.length){
            List<Integer> tempResult = new ArrayList<>(nums.length);
            for(int h = 0; h < nums.length; h++){
                tempResult.add(nums[h]);
            }
            res.add(tempResult);
            return;
        }
        for(int j = i; j < nums.length; j++){
            int tempValue = nums[j];
            nums[j] = nums[i];
            nums[i] = tempValue;
            backTrck(nums, i+1);
            nums[i] = nums[j];
            nums[j] = tempValue;
        }
    }

}