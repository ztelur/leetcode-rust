package again;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    /**
     * 动态规划
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        // 是 0， 则直接可以进行返回
        if (n == 0) {
            return 0;
        }
        // 每个位置，左侧最大值
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        // 等于前一个，或者自己的最大值
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        // 同样的方式，但是要从尾到头开始计算
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        // 计算每个位置
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            // 将左右的最小值减去 当前值
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 使用栈来进行
    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 进行一次遍历
        while (current < height.length) {
            // 当 stack 不为空，并且当前的高度大于栈首的高度，查看以该节点为右侧，左侧会提供多少雨水
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                // 将栈首放出来，因为已经有current大于它了
                int top = stack.pop();
                // 如果此时已经空了，那么就直接break
                if (stack.isEmpty())
                    break;
                // x 轴距离
                int distance = current - stack.peek() - 1;
                //
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            // 注意的是栈中的一定是降序的。因为大于时，一定谁在前边被 pop 出来。
            stack.push(current++);
        }
        return ans;
    }
}


