/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 *
 *
 * 典型的使用中序搜索的做法
 * @author libing
 * @version $Id: p二叉搜索树中第k小的元素.java, v 0.1 2022年02月23日 下午3:55 zt Exp $
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

/**
 * 中序查询
 * 如果要频繁查询的化，则可以使用额外的字段，记录下每个字节下的子节点数量，然后进行查找
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        int rank = 0;
        while (curr != null  || !stack.isEmpty()) {
            // 一直跑到最left的那个节点。然后取它的 left，发现是 null，跳出来
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 取出最 left 的节点,它是最小的
            curr = stack.pop();
            rank ++;

            if (rank == k) {
                return curr.val;
            }

            // 如果其右侧不为null，则将其右侧加入进去。
            curr = curr.right;
        }
        return curr.val;
    }
}
