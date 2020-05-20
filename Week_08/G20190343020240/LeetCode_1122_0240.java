class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001],res = new int[arr1.length];
        int index =0;
        //记录arr1
        for(int temp : arr1){
            count[temp]++;
        }
        //将arr2中数字插入res中
        for(int temp : arr2){
            for(int i = 0;i < count[temp];i++){
                res[index++] = temp;
            }
            count[temp] = 0;
        }
        //arr中原有数字排在最后
        for(int i = 0;i <= 1000;i++){
            for(int j = 0;j < count[i];j++){
                res[index++] = i;
            }
        }
        return res;
    }
}