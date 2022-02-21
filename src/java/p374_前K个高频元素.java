package java;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }



        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer val = entry.getKey();
            Integer count = entry.getValue();
            if (heap.size() >= k) {
                if (heap.peek()[1] < count) {
                    heap.poll();
                    heap.offer(new int[] {val, count});
                }
            } else {
                heap.offer(new int[] {val, count});
            }
        }

        int[] ret = new int[k];

        for (int i = 0; i < k; i ++) {
            ret[i] = heap.poll()[0];
        }
        return ret;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int left, int right, int[] ret, int retIndex, int k) {
        int picked = new Random().nextInt(right - left + 1) + left;
        Collections.swap(values, picked, left);

        int pivot = values.get(left)[1];
        int index = left;

        for (int i = left +1; i <= right; i ++) {
           if (values.get(i)[1] >= pivot) {
               Collections.swap(values, index +1, i);
               index ++;
           }
        }
        Collections.swap(values, left, index);

        if (index - left >= k) {
            // 说明排出来的多了，所以需要继续排，所以需要 left 和 index - 1
            qsort(values, left, index - 1, ret, retIndex, k);
        } else {
            // 排出来少了，但是可以先把这部分加到返回值数据中
            for (int i = left; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - left + 1) {
                qsort(values, index + 1, right, ret, retIndex, k - (index - left + 1));
            }
        }
    }
}
