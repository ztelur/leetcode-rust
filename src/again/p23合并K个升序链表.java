package again;

import java.util.PriorityQueue;

/**
 *
 * 合并 k 个升序数组
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 *
 * 关键就是怎么统计 k 个数据中最小的第一个。
 */
class Solution {
    
    // 为了使用优先队列
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;
        // 需要将所在 链表也加上。
        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }
        // 正序排列，所以this.val - 2.val
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        // 将每个链表的第一个位加入到queue中
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        // 返回值
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // 当 queue 不为空时
        while (!queue.isEmpty()) {
            // 取出一个最小的。
            Status f = queue.poll();
            // 入链
            tail.next = f.ptr;
            tail = tail.next;
            // 如果当前所在 链还有下一个节点，就将其加入进去。
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        // 返回数据
        return head.next;
    }
}
