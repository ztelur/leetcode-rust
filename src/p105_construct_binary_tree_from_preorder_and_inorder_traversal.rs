/**
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]


https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/

 **/


// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}
use std::rc::Rc;
use std::cell::RefCell;
use std::collections::BTreeMap;

pub struct Solution {}

impl Solution {

    fn calc(preoder: &[i32], inorder: &[i32], i: &mut i32, j: i32, k: i32, table: &BTreeMap<i32, usize>) -> Option<Rc<RefCell<TreeNode>>> {
      if j > k {
        return None;
      }

      // 创建一个节点
      let mut node = TreeNode::new(preoder[*i as usize]);
      *i += 1;
      // 找到值在inorder中的index
      let p = table[&node.val] as i32;
      // j p-1 是左侧
      let left = Self::calc(preoder, inorder, i, j, p-1,table);
      // p+1 k 是右侧
      let right = Self::calc(preoder, inorder, i, p+1, k, table);
      node.left = left;
      node.right = right;
      
      return Some(Rc::new(RefCell::new(node)));
    }

    pub fn build_tree(preorder: Vec<i32>, inorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
      let mut i = 0;
      // 将 inorder 转换为 table, 将val和及其index形成hashmap
      let table = inorder.iter().enumerate().map(|(p, &v)|(v,p)).collect::<BTreeMap<i32, usize>>();

      return Self::calc(&preorder, &inorder, &mut i, 0, preorder.len() as i32 - 1, &table);
    }
}