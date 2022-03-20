package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串排列
 *
 *
 *
 * 1 boolean[] visited 记录是否已经使用过
 * 2 对于重复的字符，可以排队字符列表进行排序，然后检查字符串相等的位置的visited是否已经被占用。也就是重复的字符串，只有第一个会被使用。
 */

class Solution {
    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        // 返回值
        rec = new ArrayList<>();
        // 记录是否使用过
        vis = new boolean[n];
        // s.toCharArray(); 将其转换成char数组
        char[] arr = s.toCharArray();
        // 从小到大排序
        Arrays.sort(arr);
        // sb
        StringBuffer perm = new StringBuffer();
        // 进行回溯遍历
        backtrack(arr, 0, n, perm);
        //
        int size = rec.size();
        // 转换成数组
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        // 如果 i 已经等于 n 了，那么就将结果加入
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        // 不然，对于目前 的 所有字符串
        for (int j = 0; j < n; j++) {
            // 去掉已经使用的，并且
            // 我们限制每次填入的字符一定是这个字符所在重复字符集合中「从左往右第一个未被填入的字符」
            // 也就是说每次重复数据的填入都是按照顺序填入的，所以不会出现重复的结果。
            // 这种处理重复字符串的手段应该是很常见的。
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            // 标记当前已经被使用
            vis[j] = true;
            // 加入中间结果中
            perm.append(arr[j]);
            // 继续遍历
            backtrack(arr, i + 1, n, perm);
            // 删除
            perm.deleteCharAt(perm.length() - 1);
            // 删除
            vis[j] = false;
        }
    }
}
