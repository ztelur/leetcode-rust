package java;

import java.util.*;

/**
 * 单词接龙
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2rkbs/
 *
 *  字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2rkbs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 本题要求的是最短转换序列的长度，看到最短首先想到的就是广度优先搜索
 *
 * https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode-solution/
 *
 * 广度优先搜索 + 优化建图
 */

class Solution {
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word :wordList) {
            addEdge(word);
        }

        addEdge(beginWord);

        // 最终不再里边
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        // 总节点的数量，包括虚拟节点
        int[] dis = new int[nodeNum];

        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        // 计算从 beginId 出发的路径长短
        dis[beginId] = 0;

        // 要进行广度遍历，所以需要用到队列
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);

        // 广度优先遍历，所以找到就是发现了。
        while (!queue.isEmpty()) {
            int x = queue.poll();
            // 到达了最后一个节点
            if (x == endId) {
                // 搜索到终点时，我们就找到了最短路径的长度。注意因为添加了虚拟节点，
                // 所以我们得到的距离为实际最短路径长度的两倍。
                // 同时我们并未计算起点对答案的贡献，所以我们应当返回距离的一半再加一的结果
                return dis[endId] / 2 + 1;
            }

            // 对于x的每条边
            for (int it : edge.get(x)) {
                // 确保这些节点都是第一次到达，记录的时最短到达路径，否则就不处理
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    // 加入到队列中
                    queue.offer(it);
                }
            }
        }
        return 0;
    }

    /**
     * 依据朴素的思路，我们可以枚举每一对单词的组合，判断它们是否恰好相差一个字符，以判断这两个单词对应的节点是否能够相连。但是这样效率太低，我们可以优化建图。
     *
     * 具体地，我们可以创建虚拟节点。对于单词 hit，我们创建三个虚拟节点
     * *it、h*t、hi*，并让 hit 向这三个虚拟节点分别连一条边即可。
     * 如果一个单词能够转化为 hit，那么该单词必然会连接到这三个虚拟节点之一。
     * 对于每一个单词，我们枚举它连接到的虚拟节点，把该单词对应的 id 与这些虚拟节点对应的 id 相连即可。
     *
     * @param word
     */
    private void addEdge(String word) {
        addWord(word);

        // 拿到节点的id
        int id1 = wordId.get(word);

        char[] array = word.toCharArray();
        int length = array.length;

        for (int i = 0; i < length; i ++) {
            // 形成虚拟节点，每次只改动一个节点
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            // 给节点添加上边
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            // 给 string 进行编号
            wordId.put(word, nodeNum ++);
            // 在边上加一个空的列表，表示从这个node出去的点
            edge.add(new ArrayList<>());
        }
    }

}

