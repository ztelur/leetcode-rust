package again;

import java.TreeNode;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        // 深度遍历
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 进行后续遍历
        dfs(node.left);
        dfs(node.right);
        // f 表示选中, 所以就是 g 右节点 和 g 做节点
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        // g 表示不选中,所以下个节点是否为选中都可以
        g.put(node, Math.max(f.getOrDefault(node.left, 0),
                g.getOrDefault(node.left, 0)) +
                Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
