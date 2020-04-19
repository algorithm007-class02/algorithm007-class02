package week02.g20200343040172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * LeetCode-155 最小栈
 * @author simon
 */

/**
 * 使用ArrayList来创建一个最小栈，时间耗费太高
 */
class MinStack {
    private ArrayList<Integer> array;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.array = new ArrayList<>();
    }

    public void push(int x) {
        this.array.add(x);
    }

    public void pop() {
        if (this.array.isEmpty()) {
            throw new EmptyStackException();
        } else {
            this.array.remove(this.array.size() - 1);
        }
    }

    public int top() {
        if (this.array.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return this.array.get(this.array.size() - 1);
        }
    }

    public int getMin() {
        if (this.array.isEmpty()) {
            throw new EmptyStackException();
        }
        ArrayList<Integer> arrayNew;
        int[] a = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            a[i] = array.get(i);
        }
        Arrays.sort(a);
        return a[0];
    }
}
