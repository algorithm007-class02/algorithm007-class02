package module01;

/**
 * @author JiaYunFei
 * @date 2020/4/1 20:20
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] nums = {5, 5, 10, 10, 10};
        boolean res = Lemonade(nums);
        System.out.println(res);
    }

    private static boolean Lemonade(int[] bills) {

        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five>=3){
                    five -=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
