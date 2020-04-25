class Solution {
         List<List<Integer>> list = null;
         List<Integer> temp = null;
         List<Integer> used = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new ArrayList<Integer>();
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
            if(!list.contains(temp))
                list.add(new ArrayList(temp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!used.contains(i)){
                temp.add(nums[i]);
                used.add(i);
                dfs(nums,floor+1);
                temp.remove(floor);
                used.remove(floor);
            }
        }
    }
}