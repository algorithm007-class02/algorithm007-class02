class Solution {

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                ++five;
            } else if (bill == 10) {
                //如果是10元，则需要找5元
                ++ten;
                if (five > 0) {
                    --five;
                } else {
                    return false;
                }
            } else {
                //如果是20元，则优先找1张10元和1张5元，没有则找3张5元，否则无法找零
                if (ten > 0 && five > 0) {
                    --ten;
                    --five;
                } else if (five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}