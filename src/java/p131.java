package java;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * 使用动态规划
 * 时间复杂度：O(n \cdot 2^n)O(n⋅2
 * n
 *  )，其中 nn 是字符串 ss 的长度。在最坏情况下，ss 包含 nn 个完全相同的字符，因此它的任意一种划分方法都满足要求。而长度为 nn 的字符串的划分方案数为 2^{n-1}=O(2^n)2
 * n−1
 *  =O(2
 * n
 *  )，每一种划分方法需要 O(n)O(n) 的时间求出对应的划分结果并放入答案，因此总时间复杂度为 O(n \cdot 2^n)O(n⋅2
 * n
 *  )。尽管动态规划预处理需要 O(n^2)O(n
 * 2
 *  ) 的时间，但在渐进意义下小于 O(n \cdot 2^n)O(n⋅2
 * n
 *  )，因此可以忽略。
 *
 * 空间复杂度：O(n^2)O(n
 * 2
 *  )，这里不计算返回答案占用的空间。数组 ff 需要使用的空间为 O(n^2)O(n
 * 2
 *  )，而在回溯的过程中，我们需要使用 O(n)O(n) 的栈空间以及 O(n)O(n) 的用来存储当前字符串分割方法的空间。由于 O(n)O(n) 在渐进意义下小于 O(n^2)O(n
 * 2
 *  )，因此空间复杂度为 O(n^2)O(n
 * 2
 *  )。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/fen-ge-hui-wen-chuan-by-leetcode-solutio-6jkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 分隔回文串
 */

class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();

        if (len == 0) {
            return Collections.emptyList();
        }

        /**
         * 要计算 s[i:j] 是否为回文
         * s[i:i] = s[i] == s[j] && s[i + 1 : i - 1]
         */
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            Arrays.fill(isPal[i], true);
        }

        for (int i = len - 1; i >=0; i -- ) {
            // i 在前，j在后，不允许为空，所以必须 + 1
            for (int j = i + 1; j < len; j ++) {
                // 边界情况怎么处理？
                isPal[i][j] = s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1];
            }
        }

        List<List<String>> retList = new ArrayList<>();
        dp(s, 0, retList, new ArrayList<>(), isPal);
        return retList;
    }

    public void dp(String s, int index, List<List<String>> retList, List<String> record, boolean[][] isPal) {
        if (index == s.length()) {
            retList.add(new ArrayList<>(record));
            return;
        }

        for (int j =index; j < s.length(); j ++) {
            if (isPal[index][j]) {
                String d = s.substring(index, j + 1);
                record.add(d);
                dp(s, j + 1, retList, record, isPal);
                record.remove(record.size() - 1);
            }
        }
    }
}
