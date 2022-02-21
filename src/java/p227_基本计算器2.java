package java;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int len = s.length();

        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 如果当前一个位不是数字，或者到了最后一位，则需要处理 num了。
            // 如何处理呢，根据num 和之前的符号进行处理
            if (!Character.isDigit(c) && c != ' ' || i == len -1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                // 记录当前的符号，然后下一轮处理
                preSign = c;
                num = 0;
            }
        }
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }
}
