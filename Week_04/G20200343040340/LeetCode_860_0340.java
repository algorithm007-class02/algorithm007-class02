class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0 || bills[0] != 5) return false;
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            }
            else if (i == 10) {
                ten++; five--;
            } else if (ten > 0) {
                ten--; five--;
            } else {
                five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }
}