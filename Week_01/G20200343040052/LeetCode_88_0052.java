import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode_88_0052 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0,nums1, m,n);// j
        Arrays.sort(nums2);
    }
}
