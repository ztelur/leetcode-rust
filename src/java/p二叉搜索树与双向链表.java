package java;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 *
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    // tail 和 head。
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        // 按照题目含义，进行深度中序遍历即可
        dfs(root);
        // 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        // 遍历到了空
        if(cur == null) return;
        // 先序，所以优先遍历左节点
        dfs(cur.left);
        // 进行链入双向列表
        // 如果前一个节点不为null，则将其 right 指向 cur
        if(pre != null) pre.right = cur;
        // 没有 pre，那么说明是一开始，将head指向这个节点
        else head = cur;
        // 当前节点的 left 指向 pre
        cur.left = pre;
        // pre节点变成当前节点
        pre = cur;
        dfs(cur.right);
    }
}
