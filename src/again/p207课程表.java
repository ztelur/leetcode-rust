package again;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 要先通过 prerequsties 构建成图，并且找到开头的几个课程。
        // 构造 List<List<Integer>> 的图
        edges = new ArrayList<>();
        // 每个 List<Integer>
        // 创建课程数量的边数组
        for (int i = 0; i < numCourses; i ++) {
            // 每个课程都有一个边组
            edges.add(new ArrayList<>());
        }
        // 记录该课程是否被访问到
        visited = new int[numCourses];

        // 每次表示
        for (int[] info : prerequisites) {
            // 从 1 到 0，表示要先学 1 在学 0
            // 加入一个边，表示 info[1] => info[0] 需要先学 info[1]
            edges.get(info[1]).add(info[0]);
        }

        // 遍历每个课程。
        // 遍历每个课程，而不是从无依赖的课程开始。 一旦 valid 为 false，就直接返回了
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
        // 拿到这个课程的所有边
        for (int v : edges.get(i)) {
            // 如果未遍历，则继续向上
            // 如果尚未遍历，则继续遍历
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
        // 这个很重要。主要是为了看是否有环。
        visited[i] = 2;
    }
}
