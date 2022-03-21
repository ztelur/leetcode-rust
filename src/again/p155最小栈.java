package again;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Integer> xStack;
    private Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        // 栈加入一个
        xStack.push(val);
        // 栈加入一个 当前值 和目前栈顶的值较小的一个。
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        // 一起 pop
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
