package again;


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

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();


        ListNode itr1 = l1;
        ListNode itr2 = l2;
        ListNode itr = head;
        int accumulate = 0;
        while (true) {
            if (itr1 == null || itr2 == null) {
                break;
            }
            int val = itr1.val + itr2.val + accumulate;
            accumulate = val / 10;
            ListNode tmp = new ListNode();
            tmp.val = val % 10;
            itr.next = tmp;
            itr = tmp;
            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        if (itr1 == null && itr2 == null) {

        } else if (itr1 == null) {
            while (itr2 != null) {
                ListNode tmp = new ListNode();
                int val = itr2.val + accumulate;
                accumulate = val / 10;
                tmp.val = val % 10;
                itr.next = tmp;
                itr = tmp;
                itr2 = itr2.next;
            }
            if (accumulate != 0) {

            }
        } else {
            while (itr1 != null) {
                ListNode tmp = new ListNode();
                int val = itr1.val + accumulate;
                accumulate = val / 10;
                tmp.val = val % 10;
                itr.next = tmp;
                itr = tmp;
                itr1 = itr1.next;
            }
        }

        if (accumulate != 0) {
            ListNode tmp = new ListNode();
            tmp.val = accumulate;
            itr.next = tmp;
        }
        return head.next;
    }
}
