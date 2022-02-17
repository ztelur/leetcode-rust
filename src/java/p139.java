package java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 单词拆分
 *
 * 动态规划
 *
 * dp[0:i] = dp[]
 *
 * dp[i]=dp[j] && check(s[j..i−1])
 *
 * 时间复杂度：O(n^2)O(n
 * 2
 *  ) ，其中 nn 为字符串 ss 的长度。我们一共有 O(n)O(n) 个状态需要计算，每次计算需要枚举 O(n)O(n) 个分割点，哈希表判断一个字符串是否出现在给定的字符串列表需要 O(1)O(1) 的时间，因此总时间复杂度为 O(n^2)O(n
 * 2
 *  )。
 *
 * 空间复杂度：O(n)O(n) ，其中 nn 为字符串 ss 的长度。我们需要 O(n)O(n) 的空间存放 \textit{dp}dp 值以及哈希表亦需要 O(n)O(n) 的空间复杂度，因此总空间复杂度为 O(n)O(n)。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        // 第一个就是true
        dp[0] = true;
        // i 表示dp数组的位数
        // 其中1，表示dp[1]，表示s[0]是true
        // 其中2，表示dp[2],表示s[0:1]是否为true
        // i 可以说是表示 s 的sub str 的len
        for (int i = 1;i <= len; i++) {
            // 这里j才表示真正的s上的坐标，所以就是从0到j
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
