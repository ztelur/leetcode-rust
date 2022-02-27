package java;


import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2muyh/
 *
 *
 *
 * 形成一个图，要在图中的某一个起点开始，看从它的深度遍历进去之后，是否数量能否达到 numCourses.
 *
 * https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
 */


class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 要先通过 prerequsties 构建成图，并且找到开头的几个课程。

        edges = new ArrayList<>();
        // 创建课程数量的边数组
        for (int i = 0; i < numCourses; i ++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];
        // 每次表示
        for (int[] info : prerequisites) {
            // 加入一个边，表示 info[1] => info[0] 需要先学 info[1]
            edges.get(info[1]).add(info[0]);
        }

        // 遍历每个课程，而不是从无依赖的课程开始
        for (int i = 0; i < numCourses && valid; i ++) {
            // 如果已经未遍历，则继续
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i]  = 1; // 开始遍历
        // 找到这个课程的依赖的课程
        for (int v : edges.get(i)) {
            // 如果未遍历，则继续向上
            if (visited[v] == 0) {
                dfs(v);
                // 如果已经不可能，则直接返回
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 如果遍历到了，一个重复的，则直接返回。也就是出现相互依赖，所以
                valid = false;
                return;
            }
        }
        // //因为该科目已经完成深搜，所以标记它的状态未搜索过
        visited[i] = 2;
    }
}
