class Solution {
    List<List<Integer>> list = null;
    List<Integer> temp = null;
    public List<List<Integer>> permute(int[] nums) {
            temp = new ArrayList<Integer>();
            list = new ArrayList<List<Integer>>();
            if(nums == null || nums.length <= 0)
                return list;
            dfs(nums , 0);
            return list;
    }
    public boolean isRepete(Integer nums){
        return temp.contains(nums);
    }
    public void dfs(int []nums , int floor){
        if(floor >= nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!isRepete(nums[i])){
                temp.add(nums[i]);
                dfs(nums,floor+1);
                temp.remove(floor);
            }
        }
    }
    
}