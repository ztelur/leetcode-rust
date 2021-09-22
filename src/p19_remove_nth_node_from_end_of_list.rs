/**
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given the head of a linked list, remove the nth node from the end of the list and return its head.



Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]



Maintain two pointers and update one with a delay of n steps.

 **/


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

pub struct Solution {}

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut head = head.unwrap();

        let mut fast = head.clone();
        let mut slow = head.as_mut();

        let mut meet_end = false;

        // fast 先走，如果遇到末尾了，则判断n是不是1，是1则不返回，否则则返回head的下一个
        for _ in 0..n {
            if fast.next.is_none() {
                meet_end = true;
                break;
            }
            fast = fast.next.unwrap();
        }

        if meet_end {
            if n == 1 {
                return None;
            }
            return head.next;
        }

        // 否则fast和slow一起行动，知道遇到末尾
        while let Some(node) = fast.next {
            slow = slow.next.as_mut().unwrap();
            fast = node;
        }
        //
        slow.next = slow.next.as_mut().unwrap().next.clone();
        return Some(head)
    }
}