package again;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

class Solution {

    // 但是通过栈，我们可以在遍历给定字符串的过程中去判断到目前为止扫描的子串的有效性，同时能得到最长有效括号的长度。

    /**
     * 对于遇到的每个 \text{‘(’}‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 \text{‘)’}‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            // 遇到 open 就加入到 栈 中
            if (s.charAt(i) == '(') {
                // 这里要入栈对应的位置
                stack.push(i);
            } else {
                // 遇到 close，则 pop 出来
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果当前空了，则说明，已经是无法匹配的了，所以设置进去一个当前位置
                    stack.push(i);
                } else {
                    // 说明匹配成功，里边还有，i - peek 然后 计算大小
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
