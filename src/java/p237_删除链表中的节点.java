package java;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        prev.val = node.next.val;
        prev.next = node.next.next;
    }
}
