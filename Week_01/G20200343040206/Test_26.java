public class Test_26 {

    public static void main(String[] args) {
        LeetCode_26_0206 source = new LeetCode_26_0206();

        int[] nums_0 = new int[]{};
        int[] nums_1 = new int[]{1};
        int[] nums_2 = new int[]{1,1,2};
        int[] nums_n = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};


        System.out.println(source.removeDuplicates(nums_0));
        System.out.println(source.removeDuplicates(nums_1));
        System.out.println(source.removeDuplicates(nums_2));
        System.out.println(source.removeDuplicates(nums_n));

    }


}
