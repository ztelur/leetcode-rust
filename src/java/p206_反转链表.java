package java;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode cur = prev.next;

        // 1 2 3 4 5 1是head，从 2开始，现将 1 2 反转

        while (cur != null) {
            ListNode next = cur.next; // 先保留下一个，保留3的引用
            cur.next = prev; // 将 2 指向 1
            // 只有第一次需要处理next
            if (prev.next == cur) {
                prev.next = null; // 将 1指向2的指针断路
            }
            prev = cur; // 将 prev 指向 2
            cur = next; // 将 cur 指向 3
        }
        return prev;
    }
}
