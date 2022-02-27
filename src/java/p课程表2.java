package java;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2a743/
 */


class Solution {

    private List<List<Integer>> edges;
    private int[] path;
    private int[] visited;
    private boolean valid;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<>();
        path = new int[numCourses];
        visited = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i ++) {
            edges.add(new ArrayList<>());
        }

        // 建立边关系
        for (int[] info : prerequisites) {
            // 学完info[0] 才能学习 info[1]
            edges.get(info[1]).add(info[0]);
        }


        // 依次遍历一下每个课程
        for (int i =0; i < numCourses && valid; i ++) {
            // 只有未遍历过，才进行dfs
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return path;
    }

    private void dfs(int u) {
        visited[u] = 1;

        // 找到它的边
        // 找到它依赖的课程
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1){
                // 说明没有找到，就
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        path[index--] = u;
    }
}
