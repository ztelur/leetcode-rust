/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author libing
 * @version $Id: p378_有序矩阵中第K小的元素.java, v 0.1 2022年02月21日 下午7:07 zt Exp $
 */

class Solution {
    private Random random = new Random();

    public int kthSmallest(int[][] matrix, int k) {
        int smallest = matrix[0][0];
        int width = matrix.length;
        int height = matrix[0].length;
        int largest = matrix[width - 1][height - 1];

        while (smallest < largest) {
            int mid = smallest + (largest - smallest) / 2;
            if (check(matrix, mid, k, width)) {
                largest = mid;
            } else {
                smallest = mid +1;
            }
        }
        return smallest;
    }

    private boolean check(int[][] matrix, int mid, int k, int width) {
        int i = width - 1;
        int j = 0;
        int num = 0;
        while (i >=0 && j < width) {
            if (matrix[i][j] <= mid) {
                // 一行最后一个小于，则直接全部小于，所以遍历下一行
                num += (i + 1);
                j ++;
            } else {
                i --;
            }
        }
        return num >= k;
    }
}