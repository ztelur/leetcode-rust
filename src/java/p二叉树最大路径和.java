/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 * 首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
 *
 * 具体而言，该函数的计算如下。
 *
 * 空节点的最大贡献值等于
 * 0
 * 0。
 * 非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）
 *
 *
 *
 *
 *
 *
 * @author libing
 * @version $Id: p二叉树最大路径和.java, v 0.1 2022年02月25日 下午2:46 zt Exp $
 */

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
 *
**/

public class TreeNode {
    int      val;
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

public class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 计算以该节点为子树的，以该节点为起点的最大路径合
     * @param node
     * @return
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        /**
         * 将路径根据root划分成两段，一个左边，一个右边，
         * 然后进行递归。可以找自己左右子节点的最大的。
         * 所以以当前节点的最大的路径就是 val + left + right
         */

        // 分别计算左右两个子树的最大贡献，因为有可能是负数，所以取一个 0
        int leftMaxGain = Math.max(maxGain(node.left), 0);
        int rightMaxGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftMaxGain + rightMaxGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewPath);
        // 返回节点的最大贡献值
        return node.val + Math.max(leftMaxGain, rightMaxGain);


    }
}