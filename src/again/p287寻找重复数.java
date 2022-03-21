package again;

class Solution {
    // 对于数组，进行二分查找
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        //
        int left = 1, right = length - 1, ans = -1;

        // 左右遍历
        while (left <= right) {
            // 选择一个中点
            int mid = (left + right) / 2;
            // 选择一个中间的数进行判断
            int cnt = 0;
            // 将 nums 遍历一遍，如果统计小于等于 mid 的数量
            for (int i = 0; i < length; i ++) {
                if (nums[i] <= mid) {
                    cnt ++;
                }
            }
            // 如果小于该数值，则说明并不是重复的，所以要继续向上
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                //
                right = mid - 1;
                // 需要找到一个最小的
                ans = mid;
            }
        }
        return ans;
    }
}
