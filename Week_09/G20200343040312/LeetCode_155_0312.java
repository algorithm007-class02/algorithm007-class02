//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

/*
* https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
* 核心思想：
*   以空间换时间
* attention"
*   返回时注意返回类型和返回的是哪一个栈的内容
* */

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    /*练手---实现在常数时间内检索到最小栈的元素*/
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || x<=helper.peek()){
            helper.push(x);
        }
    }

    public void pop() {
        int temp = data.pop();
        if (temp==helper.peek()){
            helper.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()){
            return data.peek();
        } throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if (!helper.isEmpty()){
            return helper.peek();
        } throw new RuntimeException("栈中元素为空");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

/*练手*/
//    private Stack<Integer> data;
//    private Stack<Integer> helper;
//
//    public MinStack() {
//        data = new Stack();
//        helper = new Stack();
//    }
//
//    public void push(int x) {
//        data.push(x);
//        if (helper.isEmpty() || x<=helper.peek()){
//            helper.push(x);
//        }
//    }
//
//    public void pop() {
//        int temp = data.pop();
//        if (helper.peek()==temp){
//            helper.pop();
//        }
//    }
//
//    public int top() {
//        if (!data.isEmpty()){
//            return data.peek();
//        } throw new RuntimeException("栈中元素为空");
//    }
//
//    public int getMin() {
//        if (!helper.isEmpty()){
//            return helper.peek();
//        } throw new RuntimeException("栈中元素为空");
//    }
/*
 * 耗时7ms（86%），使用内存42M（13%）*/

/**辅助栈和数据栈不同步
 * 为了避免浪费（ helper.add(helper.peek());），对“同步”进行优化，但要注意边界值
 *  1.辅助栈为空的时候必须放入新的数
 *  2.入栈时，仅当新元素小于或等于辅助栈栈顶元素时才入栈
 *  3.出栈时，仅当辅助栈元素等于数据栈元素的时候，才出栈（“出栈时同步”）
 *
 * attention:
 * helper.peek().equals(tmp)
 *  源码展示
 *   public static Integer valueOf(int i) {
 *     if (i >= IntegerCache.low && i <= IntegerCache.high)
 *         return IntegerCache.cache[i + (-IntegerCache.low)];
 *     return new Integer(i);
 *  说明，
 *      -128到127之间的数，会进行缓存，==比较的是数，结果为true；
 *      -128到127之外的数比较的是引用，结果为false；
 *
 *  解决办法：1. 使用.equals()比较；2.取得.int值后进行==；
 *  因此返回值为void的pop方法中要将pop出去的data栈中的数暂存，用于比较。以保证 “出栈时同步”
 *  */
//    private Stack<Integer> data;
//    private Stack<Integer> helper;
//
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        data = new Stack<>();
//        helper = new Stack<>();
//    }
//
//    public void push(int x) {
//        data.add(x);
//        if (helper.isEmpty() || x<=helper.peek()){
//            helper.add(x);
//        }
//    }
//
//    public void pop() {
//        if (!data.isEmpty()){
//            int tmp = data.pop();
//            if (helper.peek().equals(tmp)){
//                helper.pop();
//            }
//        }
//    }
//
//    public int top() {
//        if (!data.isEmpty()){
//            return data.peek();
//        }
//        throw new RuntimeException("栈中元素为空，此操作非法");
//    }
//
//    public int getMin() {
//        if (!helper.isEmpty()){
//            return helper.peek();
//        }
//        throw new RuntimeException("栈中元素为空，此操作非法");
//    }
/*
 * 耗时9ms（42%），使用内存42M（15%）*/

/**辅助栈和数据栈同步
 *  x<=helper.peek() ，即，新push的数如果小于或等于辅助栈栈顶元素则add，相等也入栈的原因是因为
 *  当连续push进去相等元素的时候，也要add，不然会造成元素缺失*/
//    private Stack<Integer> data;
//    private Stack<Integer> helper;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        data = new Stack<>();
//        helper = new Stack<>();
//    }
//
//    public void push(int x) {
//        data.add(x);
//        if (helper.isEmpty() || x<=helper.peek() ){
//            helper.add(x);
//        }else{
//            helper.add(helper.peek());
//        }
//    }
//
//    /**因为同步，同时pop*/
//    public void pop() {
//        if (!data.isEmpty()){
//            data.pop();
//            helper.pop();
//        }
//    }
//
//    public int top() {
//        if (!data.isEmpty()){
//            return data.peek();
//        }
//        throw new RuntimeException();
//    }
//
//    public int getMin() {
//        if (!helper.isEmpty()){
//            return helper.peek();
//        }
//        throw new RuntimeException();
//    }
/*
 * 耗时11ms（29%），使用内存42M（15%）*/
