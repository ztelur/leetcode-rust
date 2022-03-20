package again;

import java.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 进行先序排列，全部加到一个列表中
        preorderTraversal(root, list);
        int size = list.size();
        // 将列表中的每个node进行连接。
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        // 如果不为null
        if (root != null) {
            // 加上当前节点
            list.add(root);
            // 然后遍历左右节点
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
