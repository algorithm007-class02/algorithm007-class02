class Solution {
    static List list = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i+1;
        }
        int[] visit = new int[k];
        getSubArray (new ArrayList(),nums,0,visit);
        return list;
    }
    public void getSubArray (List temp, int[] nums,int begin, int[] visit){
        if (visit.length == temp.size()){
            list.add(new ArrayList(temp));
            return;
        }
        for (int i = begin; i < nums.length; i++){
            // if (i >= visit.length || visit[i]== 1) continue;
            temp.add(nums[i]);
            getSubArray(temp,nums,i+1,visit);
            // visit[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}