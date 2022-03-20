package java;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */

class Solution {
    // 一个作为返回值
    LinkedList<List<Integer>> res = new LinkedList<>();
    // 一个座位当前路径
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        // 遍历到头了，直接返回
        if(root == null) return;
        // 将当前节点加入到里边
        path.add(root.val);
        // 将total 减去这个值
        tar -= root.val;
        // 如果到了叶节点并且 total 已经是 0，则将数据加入到返回值中
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        // 遍历左右节点
        recur(root.left, tar);
        recur(root.right, tar);
        // 将当前数据删除，重新向上，这一个步骤容易遗漏
        path.removeLast();
    }
}
