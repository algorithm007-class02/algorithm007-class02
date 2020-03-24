class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        Integer min = minStack.peek();
        if (min == null || x <= min) {
            minStack.push(x);
        }
    }

    public void pop() {
        int po = stack.pop();
        if (po == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public int size() {
        return stack.size();
    }
}