package java;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */

/**
 *
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

  // 方法1 全部拷贝到一个数组中，在进行判断，确实，由于数组可以进行按下标访问，所以比较好判断
// 方法2 将后半段数组倒置，然后判断是否相同。
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 数量 >= 1
        if (head.next == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFistHalf(head);
        ListNode secondHalfEnd = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfEnd;
        boolean result = true;
        // 由于基数和偶数，所以有时 p2 的大小是小1的
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }


    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        return prev;
    }

    // 1 2 3 slow = 2    1 2 3 4 slow = 2
      // 1 2 3 4 5 slow = 3   1 2 3 3 2 1 slow = 3
    private ListNode endOfFistHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
