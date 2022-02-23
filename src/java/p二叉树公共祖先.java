/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 *
 * @author libing
 * @version $Id: p二叉树公共祖先.java, v 0.1 2022年02月23日 下午4:13 zt Exp $
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 有公共祖先，根据二叉树的规则，那么这个 parent 一定是 大于 p 并且小于 q 的
 * 那么可以根据这个特性进行排查，找到最后一个符合这一特点的就是找到了
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 从顶向下进行排序
        TreeNode curr = root;

        // 先假设 p 小于 q， 如果不能做这个假设，则需要自己手动排一下

        TreeNode prev = root;
        // 公共祖先有可能为其中某一个节点嘛
        while (curr != null) {
            if (curr.val >= p.val && curr.val <= q.val) {
                return curr;
            } else if (curr.val < p.val) { // 必定小于 q.val
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr;
    }

    private boolean check(TreeNode parent, TreeNode p, TreeNode q) {
        if (parent.val >= p.val && parent.val <= q.val) {
            return true;
        } else {
            return false;
        }
    }

}