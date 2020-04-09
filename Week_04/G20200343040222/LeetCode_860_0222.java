
public class LeetCode_860_0222 {

    /**
     * 用贪心算法
     * 找零的钱只可能是5或者10，两个5元等于一个10元，所以遇到找大于10元的尽量先找10元再找5元。
     * 遇到倍数的关系我们可以用贪心算法
     * 算法过程：
     * 记录剩余零钱，为5和10
     * 遍历数组
     * 如果当前是5，不用找零，5元记录+1
     * 如果是10 需要找零，去查看5元记录够不够，如果不够则返回false
     * 如果是20 需要找零15 ，先找10元记录，在看五元记录。如果拼凑不起来返回false， 对应减去最优的组合记录
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveBill = 0;
        int tenBill = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5 : {
                    fiveBill++;
                    break;
                }
                case 10 : {
                    fiveBill--;
                    tenBill++;
                    break;
                }
                case 20 : {
                    if (tenBill > 0) {
                        tenBill--;
                        fiveBill--;
                    } else {
                        fiveBill -= 3;
                    }
                    break;
                }
                default : break;
            }
            if (fiveBill < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 同样可以用贪心算法，采用递归实现，细节和lemonadeChange类似
     * @param bills
     * @return
     */
    public boolean lemonadeChangeRe(int[] bills) {
        return clerks(bills, 0, 0, 0);
    }

    /**
     *
     * @param bills 账单列表
     * @param billIndex 当前处理账单
     * @param fiveNum 当前5元记录数目
     * @param tenNum 当前10元记录数目
     * @return
     */
    private boolean clerks (int[] bills, int billIndex, int fiveNum, int tenNum) {
        if (billIndex < bills.length) {
            int bill = bills[billIndex];
            if (bill == 5) {
                return clerks(bills, billIndex + 1, fiveNum + 1,tenNum);
            } else if (bill == 10) {
                return fiveNum > 0 ? clerks(bills, billIndex + 1, fiveNum - 1, tenNum + 1);
            } else {
                if (tenNum > 0 && fiveNum > 0) {
                    return clerks(bills, billIndex + 1, fiveNum - 1, tenNum - 1);
                } else {
                    return fiveNum > 2 && cherks(bills, billIndex + 1, fiveNum - 3, tenNum)
                }
            }
        } else {
            return true;
        }
    }


}