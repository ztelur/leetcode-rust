package again;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 查找第一个大于等于 target 的下标
        int leftIdx = binarySearch(nums, target, true);
        // 查找第一个大于 target 的下标，然后 -1
        int rightIdx = binarySearch(nums, target, false) - 1;
        // 最后进行校验，因为不一定是这些数字。
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        // 正常的二分查找
        int left = 0, right = nums.length - 1, ans = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 如果 大于 target
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                // lower 模式下，则是为了找出第一个出现的位置
                right = mid - 1;
                ans = mid;
            } else {
                // == target 时，也会让 left = mid + 1 这是为了找到最后一个
                left = mid + 1;
            }
        }
        return ans;
    }
}
