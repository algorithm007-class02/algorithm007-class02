class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int element[] = new int[triangle.size()+1];
        element[0] = 0;
        int i = triangle.size()-1;
          List<Integer> temp = null;
        for(; i >= 0 ; i--){
           temp = triangle.get(i);
            for(int j = 0 ; j < temp.size() ; j++){
                element[j] = Math.min(temp.get(j)+element[j],temp.get(j)+element[j+1]);
            }
        }
        return element[0];
    }
}