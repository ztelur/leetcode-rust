package java;

import java.util.Random;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 进行快速排序。
        randomizedSelected(arr, 0, arr.length - 1, k);

        // 设置返回值
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    // left right 都是可以访问的， k 是指前k个数
    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        // 对其进行随机化排序，并返回那一个节点
        int pos = randomizedPartition(arr, l, r);

        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        // Random().nextInt(r - l + 1) + l
        int i = new Random().nextInt(r - l + 1) + l;
        // 计算出一个点
        // 将其和 right 进行交换
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        // 对比点是right
        int pivot = nums[r];
        // 从 i - 1 开始。
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            // 从 left 开始，到 r - 1
            // 如果这个节点小于 pivot，那么久将其和
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        // 将i 和 right 进行交换
        swap(nums, i + 1, r);
        // 返回
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

