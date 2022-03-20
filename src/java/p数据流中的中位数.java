package java;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
 *
 * 借助最大和最小堆
 *
 * 设元素总数为 N = m + nN=m+n ，其中 mm 和 nn 分别为 AA 和 BB 中的元素个数。
 *
 * addNum(num) 函数：
 *
 * 当 m = nm=n（即 NN 为 偶数）：需向 AA 添加一个元素。实现方法：将新元素 numnum 插入至 BB ，再将 BB 堆顶元素插入至 AA ；
 * 当 m \ne nm
 * 
 * ​
 *  =n（即 NN 为 奇数）：需向 BB 添加一个元素。实现方法：将新元素 numnum 插入至 AA ，再将 AA 堆顶元素插入至 BB ；
 *
 */

class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        // 知道，
    }

    /**
     * 由于 numnum 可能属于 “较小的一半” （即属于 BB ），
     * 因此不能将 numsnums 直接插入至 AA 。而应先将 numnum 插入至 BB ，
     * 再将 BB 堆顶元素插入至 AA 。这样就可以始终保持 AA 保存较大一半、 BB 保存较小一半。
     *
     *
     * 按照这个规律来做
     */
    public void addNum(int num) {
        if(A.size() != B.size()) {
            // 想b加
            A.add(num);
            B.add(A.poll());
        } else {
            // 相等时，说明是偶数，再加当前这数就是基数
            B.add(num);
            // 小顶堆加入一个大顶堆最大的。
            // 向 a 加
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
