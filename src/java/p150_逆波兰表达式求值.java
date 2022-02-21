package java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i ++) {
            String itr = tokens[i];
            if (isNumber(itr)) {
                stack.push(Integer.parseInt(itr));
            } else {
                switch (itr) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        Integer a = stack.pop();
                        Integer b = stack.pop();
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        Integer c = stack.pop();
                        Integer d = stack.pop();
                        stack.push(d / c);
                        break;
                    default:
                }
            }

        }
        return stack.pop();

    }

    public boolean isNumber(String str) {
        return !"+".equals(str) && !"-".equals(str) && !"*".equals(str) && !"/".equals(str);
    }
}
