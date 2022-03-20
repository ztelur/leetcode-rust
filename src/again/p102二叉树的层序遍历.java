package again;

import java.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 结果
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 加入队首
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 一层初始化一个
            List<Integer> level = new ArrayList<Integer>();
            // 在开始知道队列中的一层的数量
            int currentLevelSize = queue.size();
            // 只取出这么多数量的值
            for (int i = 1; i <= currentLevelSize; ++i) {
                // offer 和 poll
                TreeNode node = queue.poll();
                // 本层次加上
                level.add(node.val);
                // 左右进入
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 加入
            ret.add(level);
        }

        return ret;
    }
}
