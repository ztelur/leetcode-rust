package java;

import java.util.Random;

/**
 * 快排
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 * 最大堆和最小堆
 *
 *
 */

class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0,nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int left, int right, int index) {
        int q = randomPartition(a, left, right);
        if (q == index) {
            return a[q];
        } else {
            return q < index ?
                    quickSelect(a, q + 1, right, index) :
                    quickSelect(a, left, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int left, int right) {
        // 从当前任意选择一个位置
        int i = random.nextInt(right - left + 1) +1;
        // 先把选中的位置放置在末尾
        swap(a, i, right);
        int x = a[right];
        i = left - 1;
        // 最后一位是选中的数据
        for (int j = left; j < right; j++) {
            if (a[j] < x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, right);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}