package again;


/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 1 2 4 3 => 1 3 2 4
 *
 * 1 1 2 4 3 =>
 *
 * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 *
 * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */

class Solution {
    public void nextPermutation(int[] nums) {
        // 从 倒数第二个数开始
        int i = nums.length - 2;
        // 如果该数大于后边一个数，并且未到边界，则一直 --
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i 代表了第一个 nums[i] < nums[i + 1] 的数字，属于一个比较小的数了
        if (i >= 0) {
            int j = nums.length - 1;
            // 在从倒数第一个数开始，找到第一个大于它的数字
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 进行交换
            swap(nums, i, j);
        }
        // 然后进行交换
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
