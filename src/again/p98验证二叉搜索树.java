package again;

import java.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        // null 到了末尾，返回true
        if (node == null) {
            return true;
        }
        // 如果不在该区间，就返回
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 左侧是 low 和 当前节点的值 右侧是 当前节点和 upper
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
