/**
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            charCount[cur - 'a'] ++;
        }

        for (int j = 0; j < t.length(); j ++) {
            char cur = t.charAt(j);
            charCount[cur - 'a'] --;
        }

        for (int k = 0; k < charCount.length; k ++) {
            if (charCount[k] != 0) {
                return false;
            }
        }

        return true;
    }
}
