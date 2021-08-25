/**
https://leetcode.com/problems/add-two-numbers/


You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.




Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

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
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut one = l1.unwrap();
        let mut two = l2.unwrap();
        let mut root = ListNode::new(0);

        let mut res = Solution::make_node(one.val + two.val);
        root.next.get_or_insert(Box::new(res.0));

        let mut curr = &mut root.next;

        while one.next.is_some() || two.next.is_some() {
            match curr {
                None => break,
                Some(now) => {
                    one = one.next.or(Some(Box::new(ListNode::new(0)))).unwrap();
                    two = two.next.or(Some(Box::new(ListNode::new(0)))).unwrap();

                    res = Solution::make_node(one.val + two.val + res.1);

                    now.next.get_or_insert(Box::new(res.0));

                    curr = &mut now.next;
                }
            }
        }

        if res.1 > 0 {
            if let Some(now) = curr {
                now.next.get_or_insert(Box::new(ListNode::new(res.1)));
            }
        }

        root.next
    }

    fn make_node(mut result: i32) -> (ListNode, i32) {
        let single;
        if result > 9 {
            single = 1;
            result = result - 10;
        } else {
            single = 0;
        }
        (ListNode::new(result), single)
    }
}