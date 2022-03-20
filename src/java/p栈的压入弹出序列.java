package java;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 */


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        // 模拟栈的压入，按照顺序
        for(int num : pushed) {
            stack.push(num); // num 入栈
            // 如果不为空，并且栈首和 popped 的当前位置相同，则pop，并且记录 i 增加
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        // 查看最终栈中是否还有数据
        return stack.isEmpty();
    }
}
