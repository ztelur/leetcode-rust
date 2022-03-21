package again;

import java.util.Random;

class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        // 追求第 k 大的元素，也就是第 len - k 小的数
        return quickSelect(nums, 0,nums.length - 1, nums.length - k);
    }

    // left 和 right 分别是可以达到的数字。 index 是 len - k 小的数
    public int quickSelect(int[] a, int left, int right, int index) {
        // 随意选择一个，和 index 进行对比， 如果等于则返回。否则
        int q = randomPartition(a, left, right);
        // q 之前已经排好序了。
        if (q == index) {
            return a[q];
        } else {
            // 小于，则说明
            return q < index ?
                    // 小于，则说明在右侧
                    quickSelect(a, q + 1, right, index) :
                    // 大于则说明在左侧
                    quickSelect(a, left, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int left, int right) {
        // 从当前任意选择一个位置
        int i = random.nextInt(right - left + 1) +left;
        // 先把选中的位置放置在末尾
        swap(a, i, right);
        // x 就是 选中的那个数值
        int x = a[right];
        // i 等于 left - 1
        i = left;
        // 最后一位是选中的数据
        for (int j = left; j < right; j++) {
            // 从左侧到 右侧进行遍历
            if (a[j] < x) {
                // 如果大于 x 则
                swap(a, i, j);
                i++;
            }
        }
        // 将 i + 1 和 原来的 x 进行互换。
        swap(a, i, right);
        // 所以 就是 i + 的数字
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
