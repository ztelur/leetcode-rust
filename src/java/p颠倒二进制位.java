package java;

/**
 * 颠倒二进制
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2dx36/
 */

public class Solution {

    public int reverseBits(int n) {
        int rev = 0;
        // 一共 32位
        for (int i = 0; i < 32 && n != 0; ++i) {
            // n & 1 表示拿出最后一位，然后 << 表示倒转，也就是本来最后一位，要到第32位，本来2位，要到 31位。
            // |= 操作就是表示相加
            rev |= (n & 1) << (31 - i);
            // n = n >> 1 // 表示减少1位
            // >>>与>>唯一的不同是它无论原来的最左边是什么数，统统都用0填充。
            n >>>= 1;
        }
        return rev;
    }

    /**
     * 对于递归的最底层，我们需要交换所有奇偶位：
     *
     * 取出所有奇数位和偶数位；
     * 将奇数位移到偶数位上，偶数位移到奇数位上。
     * 类似地，对于倒数第二层，每两位分一组，按组号取出所有奇数组和偶数组，然后将奇数组移到偶数组上，偶数组移到奇数组上。以此类推。
     *
     * @param n
     * @return
     */
    // 2 位一组
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    // 4 位一组
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    // 8 位一组
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    // 16 为一组
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits2(int n) {
        // 1 个  1个进行交换
        n = n >>> 1 & M1 | (n & M1) << 1;
        // 2 个 2 个进行交换
        n = n >>> 2 & M2 | (n & M2) << 2;
        // 4 个 4 个进行交换
        n = n >>> 4 & M4 | (n & M4) << 4;
        // 8 个 8 个进行交换
        n = n >>> 8 & M8 | (n & M8) << 8;
        // 最后这部，交换前16 和 后 16
        return n >>> 16 | n << 16;
    }

}
