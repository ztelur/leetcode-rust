/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢列表
 *
 * 对于环性列表二，要找到如环点，则需要第三个指针
 *
 * @author libing
 * @version $Id: p141_环形链表.java, v 0.1 2022年02月22日 下午6:45 zt Exp $
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

  public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast && slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
            }
        }

        return slow == fast;
    }
}