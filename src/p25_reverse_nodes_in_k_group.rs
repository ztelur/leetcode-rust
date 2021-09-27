/**
https://leetcode.com/problems/reverse-nodes-in-k-group/

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]


https://www.cnblogs.com/grandyang/p/4441324.html

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

    fn add(head: Option<Box<ListNode>>, tail: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut head = head;
        let mut tail = tail;

        while let Some(mut new_tail) = head.take() {
            head = new_tail.next.take();
            new_tail.next = tail.take();
            tail = Some(new_tail);
        }
        return tail;
    }


    pub fn reverse_k_group(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
        let mut head = head;
        let mut tail = &mut head;
        // 不足k-group时直接返回head，否则返回一直找到最后第k个
        for _ in 0..k {
            match tail.as_mut() {
                None => return head,
                Some(tail_ref) => tail = &mut tail_ref.next,
            }
        }
        // 找到k-group的下一个
        let tail = tail.take();

        return Self::add(head, Solution::reverse_k_group(tail, k));
    }
}