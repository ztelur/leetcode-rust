package again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        // 表编程
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 结束条件，如果index 到了末尾
        if (index == digits.length()) {
            // 添加进去
            combinations.add(combination.toString());
        } else {
            // 选取当前的一个
            char digit = digits.charAt(index);
            // 得出所有的字符串
            String letters = phoneMap.get(digit);

            int lettersCount = letters.length();
            // 对于每个字符，选一个
            for (int i = 0; i < lettersCount; i++) {
                // 选
                combination.append(letters.charAt(i));
                // 递归
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 删除
                combination.deleteCharAt(index);
            }
        }
    }
}