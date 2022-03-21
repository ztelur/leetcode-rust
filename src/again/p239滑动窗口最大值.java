package again;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // PriorityQueue 优先队列 = new PriorityQueue<int[]>(new Comparator<int[]>() {
        //  @Overribe
//            public int compare(int[] o1, int[] o2) {
//
//        }
        // })
        // 优先队列，里边int[2] int[0] 是数值，int[1] 是位置
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        // 记录返回值
        int[] ret = new int[nums.length - k + 1];

        // 先填入第一个 k 个的数据
        for (int i = 0;i < k; i ++) {
            heap.offer(new int[]{nums[i], i});
        }

        // 第一批
        int index = 0;
        // 取出队首，也就是根据上边排序的第一个。上边已经是倒序排列了
        ret[index] = heap.peek()[0];
        index++;
        // 剩下的每次进行右滑
        for (int i = k; i < nums.length; i ++) {
            // 加入
            heap.offer(new int[]{nums[i],i});
            // 取出最大值
            while (true) {
                // 已经在窗口外了
                int[] itr = heap.peek();
                // 如果在窗口外, 则取出来
                if (itr[1] <= (i - k)) {
                    heap.poll();
                } else {
                    // 在窗口内，则加入结果。
                    ret[index] = itr[0];
                    index++;
                    break;
                }
            }
        }
        return ret;
    }
}
