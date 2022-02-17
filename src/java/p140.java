package java;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 *
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 *
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 这里是要找出所有可能的拆分条件。
 */

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordbreaks = backtrack(s, 0, new HashSet<>(wordDict),map);
        List<String> retList = new ArrayList<>();
        for (List<String> wordBreak : wordbreaks) {
            retList.add(String.join(" ", wordBreak));
        }
        return retList;
    }

    public List<List<String>> backtrack(String s, int index, Set<String> keySet,
                                        Map<Integer, List<List<String>>> map) {
        // 如果已经计算好过某个 index 下的结果集，就直接返回
        int length = s.length();
        if (!map.containsKey(index)) {
            List<List<String>> workBreaks = new LinkedList<>();
            if (length == index) {
                workBreaks.add(new ArrayList<>());
            }
            // 这是要判断 s[index:len-1] 能拆分多少对
            // 所以 s[index:len-1] = s[j] + backtrack[i]
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (keySet.contains(word)) {
                    List<List<String>> nextLevelWordBreaks = backtrack(s, i, keySet, map);
                    for (List<String> itr : nextLevelWordBreaks) {
                        LinkedList<String> wordbreak = new LinkedList<>(itr);
                        wordbreak.offerFirst(word);
                        workBreaks.add(wordbreak);
                    }
                }
            }
            map.put(index, workBreaks);
        }
        return map.get(index);
    }
}
