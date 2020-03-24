package com.wxs.algorithm1.week02;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_42_0316 {


    public static void main(String[] args) {

        LeetCode_42_0316 trap42 = new LeetCode_42_0316();

       int[] height =  {0,1,0,2,1,0,1,3,2,1,2,1};

        int trap = trap42.trap(height);

        System.out.println(trap);

    }

    /**
     *
     *  把左边存入栈中，需明确 一个是当前列current，一个是stack中的坐标
     *  当，current 的高度 > stack坐标在数组中的高度，且stack 不为空才会有水(需要弹出栈顶，查看current左边第一列的高度)
     *  注意： 弹出后，如果为空，则不会有水。
     *
     * 时间复杂度为 O(N*2)  == O(n) ,   空间复杂度为O(N)
     * @param height
     * @return
     */
    public int trap(int[] height) {


        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        while (current < height.length){

            while (!stack.empty()&& height[current] > height[stack.peek()]){
                // 获得水低高度，用来和两堵墙最矮高度求差，获得盛水高度
                int h = height[stack.pop()];
                if(stack.empty()){
                    break;
                }
                // 两堵墙的距离
                int dis = current - stack.peek() - 1;

                // 两堵墙的最低高度
                int min = Math.min(height[current], height[stack.peek()]);
                sum += dis * (min - h);

            }

            stack.push(current++);
        }

        return sum;


    }





}
