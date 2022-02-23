package java;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  // 使用类似于双指针的处理
  // 两个 node 进行处理


/**
 * head = [1,2,3,4,5]
 *        [0,1,0,1,0]
 * [1,3,5,2,4]
 *
 *
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroNode = head; // 偶数指针
        ListNode oneNode = head.next; // 奇数指针

        ListNode curr = head;
        int index = 0;

        while (curr != null) {
            if (index % 2 == 0) {
                // 偶数

            } else {
                // 奇数
            }


        }

    }
}
