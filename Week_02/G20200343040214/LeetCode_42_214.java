public class Solution42 {
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        long start = System.currentTimeMillis();
        System.out.println(trap(height));
        long end1 = System.currentTimeMillis();
        System.out.println(trap2(height));
        long end2 = System.currentTimeMillis();
        System.out.println(end1 - start);
        System.out.println(end2 - end1);
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 0; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public static int trap2(int[] height) {
        // 暴力法
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            int min = Math.min(max_left, max_right);
            int p = min - height[i];
            ans += p;
        }
        return ans;
    }
}
