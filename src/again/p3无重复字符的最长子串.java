package again;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = -1;
        int ret = 0;
        for (int i = 0; i < n; i ++) {
            if (i != 0 ) {
                // 左边指针向右移动，所以删除一个
                set.remove(s.charAt(i - 1));
            }

            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right ++;
            }

            ret = Math.max(ret, right - i + 1);
        }
        return ret;
    }
}
