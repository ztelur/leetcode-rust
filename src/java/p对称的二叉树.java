package java;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
 *
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        // 不对称
        if(L == null || R == null || L.val != R.val) return false;
        // 如果 L 和 R 对称了，则要分别去看它们的 left 和 right 以及 right 和 left 是否也对称
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
