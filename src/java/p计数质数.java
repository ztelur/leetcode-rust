package java;

import java.util.Arrays;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */

class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        // 使用遍历法，每个数字检测一下是否为质数
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        // 只需要从 2 到 x 的开根号来进行计算，判断是否可以整除 m * n = x，其中选择其中一个小的，一定是 i * i < x
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），
     * 即 00，这样在运行结束的时候我们即能知道质数的个数。
     */
    public int countPrimes2(int n) {
        // 表示n是否为质数
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        // 遍历 n
        for (int i = 2; i < n; ++i) {
            // 如果这个位数是
            if (isPrime[i] == 1) {
                // 结果 + 1
                ans += 1;
                // 那么，i 的 倍数 小于 n
                // 当然这里还可以继续优化，对于一个质数 xx，
                // 如果按上文说的我们从 2x2x 开始标记其实是冗余的，应该直接从 x\cdot xx⋅x 开始标记，因为 2x,3x,\ldots2x,3x,… 这些数一定在 xx 之前就被其他数的倍数标记过了，例如 22 的所有倍数，33 的所有倍数等。
                if ((long) i * i < n) {
                    //计数质数
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
