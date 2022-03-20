package java;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 *
 *
 *
 */


class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 进行递归处理
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        // 如果节点相遇了，则返回true
        if(i >= j) return true;
        // 左子树
        int p = i;
        // 一直找到第一个大于等于 j 的数据，也就是找到了右子树
        while(postorder[p] < postorder[j]) p++;
        // 右子树
        int m = p;
        // 需要查看是不是右边子树都大于某位节点
        while(postorder[p] > postorder[j]) p++;
        // 当前节点的满足平衡要求 然后分别检查左右子树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}


class Solution2 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 从后向前遍历
        for(int i = postorder.length - 1; i >= 0; i--) {
            // 如果当前大于跟，则直接返回false
            if(postorder[i] > root) return false;
            // 如果stack不为空，并且 stack 的头大于当前节点
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                // 那么就是 root
                root = stack.pop();
            // 加上当前节点
            stack.add(postorder[i]);
        }
        // 一遍发现没问题
        return true;
    }
}
