package again;

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        // 快速判断
        if (n % 2 == 1) {
            return false;
        }
        // 表编程
        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        //
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果是右侧的括号。
            if (pairs.containsKey(ch)) {
                // 则栈为空，或者栈顶不是
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                // push 进去
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
