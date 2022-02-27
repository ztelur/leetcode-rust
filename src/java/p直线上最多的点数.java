package java;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 哈希表 + 斜率表达


    public int maxPoints(int[][] points) {
        int n = points.length;
        // 另个点以下一定是没问题的
        if (n < 2) {
            return n;
        }

        int ret = 0;
        for (int i = 0; i < n; i ++) {
            // ??? 这是返回值
            // 当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线；
            if (ret > n - i || ret > n / 2) {
                break;
            }
            // 注意，这里只每次只记录一个节点的
            Map<Integer, Integer> map = new HashMap<>();
            // 只计算其后的点
            // 当我们枚举到点 ii 时，我们只需要考虑编号大于 ii 的点到点
            // ii 的斜率，因为如果直线同时经过编号小于点 ii 的点 jj，那么当我们枚举到 jj 时就已经考虑过该直线了；
            for (int j = i + 1; j < n; j++) {
                // 计算斜率
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    // 我们还需要规定分子为非负整数，如果 \textit{my}my 为负数，我们将二元组中两个数同时取相反数即可
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdxy = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdxy;
                    y /= gcdxy;
                }

                // 将这个斜率的数据进行记录
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);

            }

            // 找出和这一个节点斜率相同的做多点数量
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num);
            }
            // 和当前记录的最大返回值进行记录
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        // 不断的相互求余数，相互转换位置
        return b != 0 ? gcd(b, a % b) : a;
    }
}
