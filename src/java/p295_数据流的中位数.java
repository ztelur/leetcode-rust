/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 数据流的中位数
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author libing
 * @version $Id: p295_数据流的中位数.java, v 0.1 2022年02月21日 下午6:34 zt Exp $
 *
 *
 *
 * 1 使用有序数组
 * http://gaocegege.com/Blog/algorithm/dynamicmedian
 * 有序数组，再加上二分法查找，可以ln(n)插
 *
 * 2 使用最大最小堆来实现
 *
 * 要用堆来实现动态求中位数，需要维护两个堆，一个最大堆，一个最小堆。最大堆用来存储比中位数小的所有元素，最小堆用来存储比中位数大的所有元素。同时要维护两个int变量medianLow与medianLarge。元素数量为奇数时，中位数存储在medianLow
 * 中，元素数量为偶数时，中位数为medianLow和medianLarge的平均值。
 *
 * 插入的时候，如果插入之前有奇数个元素，那么分情况讨论：
 *
 * 如果插入的元素大于插入前的中位数，即meidanLow，就将元素插入至最小堆，然后在最小堆中取出堆顶元素，存入medianLarge。
 * 如果插入的元素小于插入前的中位数，即meidanLow，就将元素插入至最大堆，然后在最大堆中取出堆顶元素，将medianLow存入medianLarge，然后将取出的堆顶元素存入medianLow。
 * 而如果插入之前有偶数个元素，那么同样分情况讨论：
 *
 * 如果插入的元素大于medianLarge，就将元素插入至最小堆，然后把medianLow插入至最大堆，此时medianLarge就是插入后数组的中位数。
 * 如果插入的元素小于medianLow，就将元素插入至最大堆，然后把medianLarge插入至最小堆，此时meidanLaw就是插入后数组的中位数。
 * 如果插入的元素大小在medianLow与medianLarge之间，就把medianLow与medianLarge分别插入最大堆与最小堆，此时原本需插入的元素为中位数。
 *
 *
 *
 *
 */
public class MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        // 这是最大堆，大的会排在前边，所以用 b-a
        queueMin = new PriorityQueue<>((a,b) -> (b - a));
        // 最小堆，小的会排前边，
        queueMax = new PriorityQueue<>((a,b) -> (a - b));
    }

    public void addNum(int num) {

        // 如果 queueMin 是空，或者num小于其最大值，那么就加入到该堆中，表示小于中位数
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            // 如果queueMin 大小差距超出2，那么从 queueMin 取出一个最大值，加到 queueMax 中
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            // 如果 nums 大于最大堆的最大值，那么加入到 queueMax 中
            queueMax.offer(num);
            // 如果大于了，则取出一个最小值，加入到最大堆中
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) {
            return queueMin.peek();
        }
        return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}

class MedianFinder2 {
    TreeMap<Integer, Integer> nums;
    int n;
    int[] left;
    int[] right;

    public MedianFinder2() {
        nums = new TreeMap<Integer, Integer>();
        n = 0;
        left = new int[2];
        right = new int[2];
    }

    public void addNum(int num) {
        // 计数排序
        // 一些map是有妙用的
        nums.put(num, nums.getOrDefault(num, 0) + 1);
        // 当前
        if (n == 0) {
            //只有一个场景，所以数值就是 num，位置就是1
            left[0] = right[0] = num;

            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            // 基数时
            // 如果插入的数据小于 left 10 20 30，插入一个 5，则 right = left = 1 ===> left = 1 right = 2
            if (num < left[0]) {
                
            } else {
                increase(right);
            }
        } else {
            // 偶数时    10 20 30 40  left = 1 right = 2 插入一个25, left +1 right - 1
            if (num > left[0] && num < right[0]) {
                left[1] ++;
                right[1] --;
                left[0] = right[0] = num;
            } else if (num >= right[0]) {
                increase(left);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }

    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }

    private void increase(int[] iterator) {
        iterator[1]++;
        if (iterator[1] > nums.get(iterator[0])) {
            iterator[0] = nums.ceilingKey(iterator[0] + 1);
            iterator[1] = 1;
        }
    }

    private void decrease(int[] iterator) {
        iterator[1]--;
        if (iterator[1] == 0) {
            iterator[0] = nums.floorKey(iterator[0] - 1);
            iterator[1] = nums.get(iterator[0]);
        }
    }
}