package java;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 */


class Solution {

    /**
     * 如果我们把这个数组添加从0~n的n+1个元素，就变成了数组中只有一个数出现了一次，
     * 其他数字都出现了2次，让我们求这个只出现一次的数字。这题使用位运算是最容易解决的，关于位运算有下面几个规律
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++)
            xor ^= nums[i] ^ i;
        // 相当于全部亦或一遍，然后将 0 ~ n 再次全部亦或一遍
        return xor ^ nums.length;
    }

    // 逆向思维，求合，相减，就是剩余的那个数
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (0 + length) * (length + 1) / 2;
        for (int i = 0; i < length; i++)
            sum -= nums[i];
        return sum;
    }
}
