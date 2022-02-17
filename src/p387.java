import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 * exam
 * "112234455"
 * "111111"
 * "1234567"
 * "112234566"
 */
class Solution1 {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, -1);
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (charCount[c - 'a'] == -1) {
                charCount[c - 'a'] = i;
            } else {
                charCount[c - 'a'] = -2;
            }
        }

        int min = len;
        for (int j =0; j < 26; j++) {
            if (charCount[j] > 0) {
                min = Math.min(min, charCount[j]);
            }
        }
        return min == len ? -1: min;
    }

    public final static void main(String[] args) {
        String s = "leetcode";
        Solution1 solution1 = new Solution1();
        solution1.firstUniqChar(s);
    }
}
