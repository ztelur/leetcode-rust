

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);

        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        // 计算从这个节点开始的，一共有几条
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        // 如果等于，则直接++1，表示只有这一个的情况
        if (val == targetSum) {
            ret++;
        }
        // 分别查找左右的 targetSum - val 的情况。
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);

        return ret;
    }
}

class Solution {
    // 使用前缀
    public int pathSum(TreeNode root, int targetSum) {
        //
        HashMap<Long, Integer> prefix = new HashMap<>();

        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        // 将累加值进行累加，表示从root到当前节点的前缀合
        curr += root.val;
        // 查看
        ret = prefix.getOrDefault(curr - targetSum, 0);

        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}