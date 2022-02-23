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

        // 注意 head 是不会动的，可以直接返回的
        ListNode preOneNode = head; // 偶数指针
        ListNode oneNode = head.next; // 奇数指针

        // [1,2,3,4,5]
        // [0,1,0,1,0]

        /**
         *
         * [1,2,3,4,5]
         * 从 2 开始，它是基数，跳过 pre 和 one 分别指向 1 和 2
         * 到了3，它是偶数，所以它被查到了 pre 的后边 整个数组变成了 [1,3,2,4,5] 此时，pre指向3，one指向2
         * 到了4，它是基数，进行跳过
         * 到了5，它是偶数，需要替换，插入到2的前边 [1,3,5,2,4]
         */

        // 从 index = 1 也就是 2 开始
        ListNode curr = head.next;
        int index = 1;

        while (curr != null) {
            if (index % 2 == 0) {
                // 偶数 到了 3，需要插入到原来的 oneNode 前边
                preOneNode.next = curr;
                oneNode.next = curr.next;
                curr.next = oneNode;

                preOneNode = curr;
                oneNode = curr.next;
                curr = oneNode.next;
                index ++;
            } else {
                // 奇数 直接跳过 2 不动
                index ++;
                curr = curr.next;
            }
        }
        return head;
    }
}
