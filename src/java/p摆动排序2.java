package java;

import java.util.Random;

/**
 * 摆动排序 2
 *
 *
 * https://leetcode-cn.com/problems/wiggle-sort-ii/solution/yi-bu-yi-bu-jiang-shi-jian-fu-za-du-cong-onlognjia/
 *
 * 快速选择 + 3-way-partition
 *
 * // 其实只要是能将数组分成两组，一组都大于另外一组就可以了。就和先立刻排序，然后再两个两个交换来进行处理
 * // 先通过快速选择，将中位数选择出来，然后按照中卫数进行划分
 *
 *
 */

class Solution {

    // 因为只是要局部顺序，所以只要进行排序就行了。
    private Random random = new Random();
    int n = -1;
    public void wiggleSort(int[] nums) {

        int length = nums.length;
        // 找出中间数
        int midIndex = quickSelect(nums,0, length - 1);
        int mid = nums[midIndex];

        // 三分法
        for (int i = 0, j = 0, k = length - 1; j <= k;) {
            if (nums[getV(j, length)] > mid) {
                swap(nums, getV(j++, length), getV(i++, length));
            } else if (nums[getV(j)] < mid) {
                swap(nums, getV(j, length), getV(k--, length));
            } else {
                j ++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;

    }

    public int getV(int i, int n) {
        return (1 + 2 * i) % (n|1);
    }

    public int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;

        while (l < r) {
            // 快排的思想，先将右侧没问题的处理了
            while (l < r && nums[r] >= pivot) {
                r --;
            }

            // 遇到一个 < pivot 的
            if (l < r) {
                nums[l] = nums[r];
                l ++;
            }

            while (l < r && nums[l] <= pivot) {
                l ++;
            }
            // 遇到一个 > pivot 的
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        // pivot 分出了两块，一块全部大于它，一块全部小于它
        nums[l] = pivot;

        // 恰好是中位数
        if (l == nums.length / 2) {
            return l;
        } else if (l > nums.length / 2) {
            return this.quickSelect(nums, left, l - 1);
        } else {
            return this.quickSelect(nums, l + 1, right);
        }



    }

}