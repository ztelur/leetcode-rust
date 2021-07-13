/**
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 **/

pub struct Solution {}

// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

impl Solution {
    pub fn merge_two_lists(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
      let mut result_head = ListNode::new(0);
      let mut current_head = &mut result_head;
      let mut l1_current = l1;
      let mut l2_current = l2;

      while l1_current.is_some() && l2_current.is_some() {
        let mut l1_d = l1_current.take();
        let mut l2_d = l2_current.take();

        if let (Some(mut l1_head), Some(mut l2_head)) = (l1_d, l2_d) {
          if l1_head.val <= l2_head.val {
            l1_current = l1_head.next.take();
            l2_current = Some(l2_head);
            current_head = current_head.next.get_or_insert(l1_head);
          } else {
            l2_current = l2_head.next.take();
            l1_current = Some(l1_head);
            current_head = current_head.next.get_or_insert(l2_head);
          }
        }
      }
      if l1_current.is_some() {
        current_head.next = l1_current
      }
      if l2_current.is_some() {
        current_head.next = l2_current
      }

      return result_head.next;
    }
}