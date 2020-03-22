import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(nums).toString());

    }

    // 暴力法 超时
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list =  new ArrayList<>();
        if(len < 3) return  list;
        // 从小到大排序
        Arrays.sort(nums);
        for (int i=0; i< len-2; i++){
            int first = i+1;
            int last = len-1;
            if(nums[i] >0 ) break;// 当前数字大于0则和一定大于零
            // 去掉已经匹配过的
            if( i>0 && nums[i] == nums[i-1]) continue;
            while (first < last){
                int sum = nums[i] + nums[first] + nums[last];
                if(sum == 0){
                    // 满足条件
                    list.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    // 去重
                    while ( first < last && nums[first] == nums[first+1]) first ++ ;
                    while (first < last && nums[last] == nums[last-1]) last --;
                    first += 1;
                    last -= 1;
                } else if(sum < 0){
                    // 偏左边 右移
                    first += 1;
                } else {
                    // 偏右边 左移
                    last -= 1;
                }
            }
        }
        return list;
    }
    // 暴力法 超时
    public static List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list =  new ArrayList<>();
        Arrays.sort(nums);
        List<String> sot = new ArrayList<>();
        for (int i=0; i< len -2; i++){
            for (int j=i+1; j< len-1 ;j++){
                for(int k=j+1; k< len; k++){
                    if(nums[i] + nums[j]+ nums[k] == 0){
                        String so = nums[i]+""+nums[j]+""+nums[k];
                        if(!sot.contains(so)){
                            sot.add(so);
                            List<Integer> datas = new ArrayList<>();
                            datas.add(nums[i]);
                            datas.add(nums[j]);
                            datas.add(nums[k]);
                            list.add(datas);
                        }
                    }
                }
            }
        }
        return list;
    }
}
