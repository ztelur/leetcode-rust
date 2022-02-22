package java;

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
  // 使用归并排序，自底向上
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode itr = head;
        while (itr != null) {
            length ++;
            itr = itr.next;
        }

        // 初始化，引入dummp

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 将列表分为若干个长度为 subList 的子数组，并且按照两个一组进行合并
        for (int subLen = 1; subLen < length; subLen = subLen * 2) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next; // curr 用来记录拆分链表的位置

            while (curr != null) { // 链表还未拆完
                ListNode head1 = curr;
                // // 拆分出长度为subLen的链表1
                // 注意是 1
                for (int i = 1; i < subLen && curr != null && curr.next != null ; i ++) {
                    curr = curr.next;
                }

                // 拆分出长度为 subLen 的链表2

                ListNode head2 = curr.next; // 第二个链表的头，第一个链表末尾的下一个

                curr.next = null; // 暂时断链
                curr = head2;

                for (int i =1; i < subLen && curr != null && curr.next != null; i ++) {
                    curr = curr.next;
                }

                // 再次断开 第二个链路的最后的 next
                ListNode next = null;
                if (curr != null) {
                    next = curr.next; // next 用于记录 拆分为两个链表的位置
                    curr.next = null; // 断开链接
                }


                ListNode merged = mergeTwoList(head1, head2);
                prev.next = merged;
                // 将 prev 引导到 2 * SubLen 之后去，进行下一轮处理
                while (prev.next != null) {
                    prev = prev.next;
                }
                // // next用于记录 拆分完两个链表的结束位置
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 循环条件的退出一个是其中一个到末尾了
        while (l1 != null && l2 != null) {
            // 判断 l1 和 l2 的大小
            if (l1.val < l2.val) {
                // l1 小，curr 指向l1
                curr.next = l1;
                l1 = l1.next; // l1 向下走一步
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 要处理剩下的
        if (l1 == null) {
            curr.next = l2;
        }
        if (l2 == null) {
            curr.next = l1;
        }

        return dummy.next;
    }
}
