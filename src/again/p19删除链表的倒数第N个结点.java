package again;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 一个是保护的，
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        // second 是要那 倒数 n + 1个
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
