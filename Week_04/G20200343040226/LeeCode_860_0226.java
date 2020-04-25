package com.logic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: welllu
 * @Date: 2020/4/4 18:07
 * @Description:
 */
public class LeeCode_860_0226 {
    public boolean lemonadeChange(int[] bills) {
        Queue<Integer> queue = new PriorityQueue<> ( Comparator.reverseOrder()
        );
        for(int i = 0;i < bills.length; i ++) {
            int change = bills[i] - 5;

            while(change > 0) {
                if(queue.size() <= 0) return false;
                boolean isFound = false;
                for(Integer j: queue) {
                    if(change - j >= 0) {
                        change = change - j;
                        queue.remove(j);
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) return false;
            }
            if(bills[i] < 20) {
                queue.add(bills[i]);
            }
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill: bills) {
            switch(bill) {
                case 5:
                    five ++;
                    break;
                case 10:
                {
                    five --;
                    ten ++;
                    break;
                }
                case 20:
                {
                    if(ten > 0) {
                        ten --;
                        five --;
                    } else{
                        five -= 3;
                    }
                    break;
                }
            }
            if(five < 0) {
                return false;
            }
        }

        return true;

    }
}
