package again;

import java.TreeNode;

class Solution {
    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 分别去左右节点去查找
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        // 如果左右都返回true 或者其中一个为 true，并且当前值等于
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        // 返回向上返回结果
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
