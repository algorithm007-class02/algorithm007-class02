class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 下标为0的元素代表5块的数量，下标为1的元素代表10块的数量
        int[] temp = new int[2];
        int currIndex = 0;
        while (currIndex < bills.length) {
            if (bills[currIndex] == 5) {
                temp[0]++;
            } else if (bills[currIndex] == 10) {
                if (--temp[0] < 0) break;
                temp[1]++;
            } else {
                if (temp[0] - 1 < 0 || temp[1] - 1 < 0) {
                    if (temp[0] - 3 < 0) { 
                        break;
                    } else {
                        temp[0] -= 3;
                    }
                } else {
                    --temp[0];
                    --temp[1];
                }
            }
            currIndex++;
        }
        return currIndex == bills.length;
    }
}