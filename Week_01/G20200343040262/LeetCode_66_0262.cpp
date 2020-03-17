/*
LeetCode
（加一）题目66描述：
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
*/

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();//该非负整数的位数
        for (int i = n - 1; i >= 0; i--) {
            if (++digits[i] == 10) {//进位
                digits[i] = 0;
            }
            else {//不进位，直接返回
                return digits;
            }
        }
        digits.insert(digits.begin(), 1);//首位进位时，插入1至数组首位
        return digits;
    }
};