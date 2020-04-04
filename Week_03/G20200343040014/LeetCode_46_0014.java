class Solution {
    static List list = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        getSubList (new ArrayList(),visited,nums);
        return list;
    }

    public void getSubList (List temp,int[] visited,int[] nums){
        if (temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return ;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1) continue;
            visited[i] = 1;
            temp.add(nums[i]);
            getSubList(temp,visited,nums);
            visited[i] = 0;
            temp.remove(temp.size()-1);
        }
    }
}