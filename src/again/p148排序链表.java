package again;

class Solution {

    // 自底向上的归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 先统计对应的 长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 初始化，引入dummp
        ListNode dummyHead = new ListNode(0, head);
        // 从长度为1 开始搞
        //         // 将列表分为若干个长度为 subList 的子数组，并且按照两个一组进行合并
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                // // curr 用来记录拆分链表的位置
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //
                ListNode head2 = curr.next;
                // 将连进行断链
                curr.next = null;


                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 记录下后一个的连接。
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    // 断链
                    curr.next = null;
                }
                // 对  head1 和 head2 进行断开
                ListNode merged = merge(head1, head2);
                // prev 一直到最后一个
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 然后 curr 到最后断链的地方，进行下一轮操作。
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        // 对剩下的进行排序
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        // 继续处理剩下的
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
