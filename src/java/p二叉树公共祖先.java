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

import java.util.HashMap;
import java.util.Map;

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
     private Map<Integer, TreeNode> parentMap = new HashMap<>();
     private Map<Integer, Boolean> visitedMap = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        // 从 p 开始，向上一个一个寻找对应的 parent
        while (p != null) {
            visitedMap.put(p.val, true);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (visitedMap.getOrDefault(q.val, false)) {
                return q;
            }

            q = parentMap.get(q.val);
        }

        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }
    }


    private TreeNode ans;



    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

 }