package again;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // 只需要记录 2个值
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        // 从第三个开始
        for (int i = 2; i < length; i++) {
            // f(i) = max(f(i-1), f(i-2) + val);
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
            // 一直修改中间值
        }
        return second;
    }
}
