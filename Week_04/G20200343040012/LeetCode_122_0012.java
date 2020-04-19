class Solution {

    /**
     * 贪心算法
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveYuan = 0;
        int tenYuan = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveYuan++;
            } else if (bill == 10) {
                if (fiveYuan == 0) {
                    return false;
                }
                fiveYuan--;
                tenYuan++;
            } else {
                if (fiveYuan > 0 && tenYuan > 0) {
                    fiveYuan--;
                    tenYuan--;
                } else if (fiveYuan >= 3) {
                    fiveYuan -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}