/**
 https://leetcode.com/problems/sort-list/

 Given the head of a linked list, return the list after sorting it in ascending order.


 Input: head = [4,2,1,3]
 Output: [1,2,3,4]

 Input: head = [-1,5,3,4,0]
 Output: [-1,0,3,4,5]
 Example 3:

 Input: head = []
 Output: []

 Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 https://leetcode.com/problems/sort-list/solution/

 **/


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
     ListNode tail = new ListNode();
     ListNode nextSubList = new ListNode();

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();

        for (int size = 1;  size < n; size = size * 2) {
            tail = dummyHead;

            while (start != null) {
                if (start.next == null) {
                    tail.next= null;
                    break;
                }

                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode split(ListNode start, int size) {
        ListNode midPre = start;
        ListNode end = start.next;
        // use fast and slow approach to find middle and end of second linked list

        for (int index = 1; index < size && (midPre.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            
            if (midPre.next != null) {
                midPre = midPre.next;
            }
        }


    }

    int getCount(ListNode node) {
        int cnt = 0;
        ListNode ptr = node;
        while (ptr != null) {
            cnt ++;
            ptr = ptr.next;
        }
        return cnt;
    }
}