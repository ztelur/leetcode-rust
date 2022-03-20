package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.

 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;

        for (int i = 0; i < length; i ++) {
            map.put(inorder[i], i); // 使用 hashmap，避免每次找根节点都要遍历一次数组
        }
        return myBuildTree(preorder, inorder, 0, length - 1, 0, length - 1);

    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        // 递归条件结束
        if (preleft > preright) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preleft]);
        // 找到它在中序的位置
        int rootIndex = map.get(preorder[preleft]);

        treeNode.left = myBuildTree(preorder, inorder, preleft + 1, rootIndex - inleft + preleft, inleft, rootIndex - 1);
        treeNode.right = myBuildTree(preorder, inorder, rootIndex - inleft + preleft + 1, preright, rootIndex +1, inright);
        return treeNode;
    }
}
