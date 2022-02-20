package java;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * int[][] nums = new int[][] {{1,2},{3,4}}
 * w = 2 h = 2
 * [1,1] 1 [1,2] = 2
 * [2,1] 3 [2,2] = 4
 *
 * 1 2
 * 3 4
 *
 *
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int w = matrix.length - 1, h = matrix[0].length;
        int i = w,j = 0;
        while (i >= 0 && j < h) {
            int current = matrix[i][j];
            if (current == target) {
                return true;
            } else if (current < target) {
                j ++;
            } else {
                i --;
            }
        }
        return false;
    }
}
