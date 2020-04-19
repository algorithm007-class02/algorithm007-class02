class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0) return true;
        if(bills[0] != 5) return false;
        int five = 1, ten = 0;
        for (int i = 1 ; i < bills.length; i++) {
            if (bills[i] == 5)
                five++;
            else if (bills[i] == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
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
//当第一个不为5时，直接退出，当数组为空也表示没有顾客，就不存在不能找零的问题
//思路是枚举5、10、20时候的情况，尽量优先付10，没有10则再付5