package again;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            // 遍历到open后，直接 + 1
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                // 如果 ( 数量为0 则表示 ） 多了，需要加
                if (lremove == 0) {
                    rremove++;
                } else {
                    // 否则进行减
                    lremove--;
                }
            }
        }
        // 通过这样的计数规则，得到的「左括号」和「右括号」的数量就是各自最少应该删除的数量。
        helper(s, 0, lremove, rremove);

        return res;
    }

    // 回溯法进行查找结果
    private void helper(String str, int start, int lremove, int rremove) {
        // 如果发现都是 0
        if (lremove == 0 && rremove == 0) {
            // 检查是否是合格的。然后返回
            if (isValid(str)) {
                res.add(str);
            }
            //
            return;
        }
        // 从 开始到结束
        for (int i = start; i < str.length(); i++) {
            // 进行去重复的操作，不是开始，并且自己不应该等于i-1
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                // 这个情况，尝试去掉一个左括号。
                // 注意，这里是 需要记录一个 i 的。也就是需要记录下start的位置，这也是防止重复的一个策略。
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            // 尝试去掉一个右括号。
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        // 判断是否为合理的
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            // 是则 ++
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                // 进行减减
                cnt--;
                // 小于0则返回false
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}
