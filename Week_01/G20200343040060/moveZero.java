
public class MoveZero {
    public static void main(String[] args) {
        int[] num = {0, 0, 2, 3, 1};
        int[] res = Move(num);
         System.out.println(Arrays.toString(res));

    }

    private static int[] Move(int[] num) {
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                num[j] = num[i];
                if (i != j) {
                    num[i] = 0;
                }
                j++;
            }
        }
        return num;
    }
}