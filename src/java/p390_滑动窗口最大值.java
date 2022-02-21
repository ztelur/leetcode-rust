package java;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int[] ret = new int[nums.length - k + 1];

        for (int i = 0;i < k; i ++) {
            heap.offer(new int[]{nums[i], i});
        }

        int index = 0;
        ret[index] = heap.peek()[0];
        index++;

        for (int i = k; i < nums.length; i ++) {
            heap.offer(new int[]{nums[i],i});
            while (true) {
                // 已经在窗口外了
                if (heap.peek()[1] < (i - k)) {
                    heap.poll();
                } else {
                    ret[index] = heap.peek()[0];
                    index++;
                }
            }
        }
        return ret;
    }

    /**
     * 由于我们需要求出的是滑动窗口的最大值，如果当前的滑动窗口中有两个下标 ii 和 jj，其中 ii 在 jj 的左侧（i < ji<j），并且 ii 对应的元素不大于 jj 对应的元素（\textit{nums}[i] \leq \textit{nums}[j]nums[i]≤nums[j]），那么会发生什么呢？
     *
     * 当滑动窗口向右移动时，只要 ii 还在窗口中，那么 jj 一定也还在窗口中，这是 ii 在 jj 的左侧所保证的。因此，由于 \textit{nums}[j]nums[j] 的存在，\textit{nums}[i]nums[i] 一定不会是滑动窗口中的最大值了，我们可以将 \textit{nums}[i]nums[i] 永久地移除。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        // 单向队列
        Deque<Integer> deque = new LinkedList<>();

        for (int i =0; i < k; i ++ ) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 大于，则删除掉前边的值
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < len; i ++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}
