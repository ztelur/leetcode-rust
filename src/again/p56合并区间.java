package again;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // new Comparator<int[]>() {
        //  public int compare(int[] a1, int[] a2) {
        //      return
        //  }
        // }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        // 先进行排序
        List<int[]> merged = new ArrayList<>();
        // 依次进行遍历
        for (int i = 0; i < intervals.length; ++i) {

            int L = intervals[i][0], R = intervals[i][1];
            // 如果当前为空，或者末尾的第一个的 right 要小于 当前的 left，那么就新建一个非 merge的
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 否则 将末尾第一个的 right 修改成 当前right 和 原值right中最大的一个。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        // 返回数据
        return merged.toArray(new int[merged.size()][]);
    }
}
