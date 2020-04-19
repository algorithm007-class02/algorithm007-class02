package week04.g20200343040172;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * LeetCode-860 Lemonade change 柠檬水找零
 *
 * 此题考虑有问题，必须按照先后顺序找0，比如现在收了20，没有零钱找零，等到后面收起了零钱再找零是不行的
 */

public class LeetCode_860_0172 {

    public static boolean lemonadeChange(int[] bills) {
        int[] count = new int[21];
        for (int i = 0; i < bills.length; i++) {
            count[bills[i]]++;
        }

        if (count[10] != 0) {
            int countTen = count[10];
            while (countTen > 0) {
                if (count[5] >= 1) {
                    count[5]--;
                    countTen--;
                } else {
                    return false;
                }
            }
        }
        if (count[20] != 0) {
            int countTwenty = count[20];
            while (countTwenty > 0) {
                int five = count[5];
                if (five <= 0) {
                    return false;
                }
                if (five >= 3) {
                    count[5] -= 3;
                    countTwenty--;
                } else {
                    if (count[10] > 0) {
                        count[10]--;
                        if (count[5] >= 1) {
                            count[5]--;
                        } else {
                            return false;
                        }
                        countTwenty--;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
