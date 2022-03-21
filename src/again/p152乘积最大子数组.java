package again;

class Solution {
    public int maxProduct(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int max  = nums[0];
        int min = nums[0];

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i ++) {
            int value = nums[i];

            if (value >= 0) {
                result = Math.max(max * value, result);
                max = Math.max(value, max * value);
                min = Math.min(value, min * value);
            } else {
                result = Math.max(min * value, result);
                max = Math.max(value, min * value);
                min = Math.min(value, max * value);
            }
        }
        return result;
    }
}
