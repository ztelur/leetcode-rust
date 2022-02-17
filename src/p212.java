/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *  https://leetcode-cn.com/problems/word-search-ii/
 *
 * 单词搜索2
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaorig/
 * @author libing
 * @version $Id: p212.java, v 0.1 2022年02月17日 下午6:43 zt Exp $
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie1 trie = new Trie1();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> resultSet = new HashSet<>();

        for (int i =0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                dfs(board, trie, i, j, resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    private void dfs(char[][] board, Trie1 trie, int xIndex, int yIndex, Set<String> result) {
        // 如果已经到了默认，则说明已经遍历到了一个词
        if (trie.isEnd()) {
            result.add(trie.getWord());
        }

        if (xIndex < 0 || xIndex >= board.length) {
            return;
        }

        if (yIndex < 0 || yIndex >= board[0].length) {
            return;
        }


        char c = board[xIndex][yIndex];

        if (c == '#') {
            return;
        }

        int childNum = c - 'a';

        // 不匹配，则返回
        Trie1 child = trie.getChild(childNum);
        if (child == null) {
            return;
        }

        board[xIndex][yIndex] = '#';

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < directions.length; i++) {
            dfs(board, child, xIndex + directions[i][0], yIndex + directions[i][1], result);
        }
        board[xIndex][yIndex] = c;
    }

}

class Trie1 {
    private Trie1[] children;
    private boolean isEnd;
    private String word;

    public Trie1() {
        word = "";
        // 一共26个数字
        children = new Trie1[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie1 node = this;
        for (int i =0; i < word.length(); i ++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie1();
            }
            node = node.children[index];
        }
        node.word = word;
        node.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getWord() {
        return word;
    }

    public Trie1 getChild(int index) {
        return this.children[index];
    }
}