package com.algorithm.firstWeek;

/**
 *
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {4,3,2,1};

//        System.out.println(plusOne(digits));
        digits = myPlusOne(digits, 9);

        for(int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }

        System.out.println();
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] myPlusOne(int[] digits, int n) {
        int up = 0, num;
        for(int i = digits.length - 1; i >= 0 ; i--) {
            if(i == digits.length - 1) {
                num = digits[i] + n;
            } else {
                num = digits[i] + up;
            }

            if(num >= 10) {
                up = 1;
                digits[i] = num % 10;

                if(i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    for(int j = 0; j < digits.length; j++) {
                        newDigits[j+1] = digits[j];
                    }
                    return newDigits;
                }
            } else {
                up = 0;
                digits[i] = num;
            }
        }

        return digits;
    }
}
