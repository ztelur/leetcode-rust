package again;

import java.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        // 当 root 不为空并且 stk 不为 空时
        while (root != null || !stk.isEmpty()) {
            // 当 root 不为空，则将其加入栈，并找其 left
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 进行 pop
            root = stk.pop();
            // pop 出来的进行加入
            res.add(root.val);
            // 找 right 分支
            root = root.right;
        }
        return res;
    }
}
