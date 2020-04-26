class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;
        int needReturn = 0;
        for (int i = 0; i < bills.length; i++){
            int value = bills[i];
            needReturn = value - 5;
            switch (value){
                case 5:
                {
                    fiveCount ++;
                }
                break;
                case 10:
                {
                    fiveCount --;
                    tenCount ++;
                }
                break;
                case 20:
                {
                    if (tenCount > 0){
                        fiveCount --;
                        tenCount --;
                    }else {
                        fiveCount -=3;
                    }
                    twentyCount ++;
                }
                break;
            }
            if (fiveCount<0 || tenCount <0) 
            {
                return false;
            }
        }
        return true;
    }
}