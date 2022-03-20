package again;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // 当前的数量等于 max * 2 说明已经结束了。
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 如果 open 小于，则可以添加一个 (
        if (open < max) {
            cur.append('(');
            // 进行遍历
            backtrack(ans, cur, open + 1, close, max);
            // 删除
            cur.deleteCharAt(cur.length() - 1);
        }
        // 如果 close 小于 open，这个是关键，只有在 小于 open 的情况下，
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
