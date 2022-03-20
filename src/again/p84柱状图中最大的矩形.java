package again;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题解讲得有点复杂，不利于理解。。。说白了，这题考的基础模型其实就是：在一维数组中对每一个数找到第一个比自己小的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
 *
 *
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // 单调栈
        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // 如果不为空，并且顶部是比自己大的，则进行出栈
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            // left 的 i 的左侧比自己的小的第一个就是目前栈顶的数据，或者是 -1
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            // 将自己插入进去。
            mono_stack.push(i);
        }

        // 计算右侧。
        mono_stack.clear();
        // 要从右侧开始
        for (int i = n - 1; i >= 0; --i) {

            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        // 然后每个节点进行遍历，等于 左右相减 * height，并与最大值进行对比
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}

