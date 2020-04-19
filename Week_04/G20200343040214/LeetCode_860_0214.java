package level1;

public class Solution860 {
    public static void main(String[] args) {
        lemonadeChange(new int[] { 5, 5, 10, 20 });
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five += 1;
            }
            if (bill == 10) {
                if (five >= 1) {
                    five -= 1;
                    ten += 1;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (ten >= 1 && five >= 1) {
                    ten -= 1;
                    five -= 1;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
