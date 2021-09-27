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

pub struct Solution{}

impl Solution {
    pub fn sort_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {

    }
}