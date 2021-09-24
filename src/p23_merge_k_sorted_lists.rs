/**
https://leetcode.com/problems/merge-k-sorted-lists/

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

https://leetcode.com/problems/merge-k-sorted-lists/solution/


solution:
1 多个指针一个一个比较
2 先合并两个，然后依次合并
3 对方案2的升级，divide and conquer


https://leetcode.com/problems/merge-k-sorted-lists/discuss/923014/Rust-4ms-divide-and-conquer
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

    pub fn merge(l1: Box<ListNode>, l2: Box<ListNode>) -> Box<ListNode> {
        let mut n1 = Some(&l1);
        let mut n2 = Some(&l2);
        let mut list: Box<ListNode>;
        // init first one
        if l1.val < l2.val {
            n1 = l1.next.as_ref();
            list = Box::new(ListNode::new(l1.val));
        } else {
            n2 = l2.next.as_ref();
            list = Box::new(ListNode::new(l2.val));
        }

        let mut node = &mut list;

        while n1 != None || n2 != None {
            match (n1, n2) {
                (Some(v1), Some(v2)) => {
                    // 找出最小的一个
                    node.next = Some(Box::new(ListNode::new(v1.val.min(v2.val))));
                    // 向下一个节点
                    node = node.next.as_mut().unwrap();

                    if v1.val < v2.val {
                        n1 = v1.next.as_ref();
                    } else {
                        n2 = v2.next.as_ref();
                    }
                },
                (Some(v1), None) => {
                    node.next = Some(Box::new(ListNode::new(v1.val)));
                    node = node.next.as_mut().unwrap();
                    n1 = v1.next.as_ref();
                },
                (None, Some(v2)) => {
                    node.next = Some(Box::new(ListNode::new(v2.val)));
                    node = node.next.as_mut().unwrap();
                    n2 = v2.next.as_ref();
                },
                (None, None) => break
            }
        }
        return list;
    }

    pub fn merge_all(mut lists: Vec<Box<ListNode>>) -> Option<Box<ListNode>> {
        if lists.len() < 2 {
            // 只有一个，直接返回
            return lists.into_iter().next();
        } else {
            // 将多个列表拆分成2个
            let (left, right) = (lists.split_off(lists.len() /2), lists);
            // 继续拆分，去拆分left
            let left_node = Solution::merge_all(left);
            // 继续拆分，right
            let right_node = Solution::merge_all(right);
            // 将左右合并
            match (left_node, right_node) {
                (Some(n1), Some(n2)) => Some(Solution::merge(n1, n2)),
                (Some(n1), None) => Some(n1),
                (None, Some(n2)) => Some(n2),
                (None, None) => None
            }
        }
    }

    pub fn merge_k_lists(lists: Vec<Option<Box<ListNode>>>) -> Option<Box<ListNode>> {
        Solution::merge_all(lists.into_iter()
            .filter(|val| val.is_some())
            .map(|val|val.unwrap())
            .collect::<Vec<Box<ListNode>>>()
        )
    }
}