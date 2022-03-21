package again;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 关键，最小堆。大于最小值，才能入堆。
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map 计数都不变
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // 转换成列表
        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        // 返回值
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        // 随机选一个
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        // 把这个 和 start 进行换位置
        Collections.swap(values, picked, start);
        // 取出对应的出现次数
        int pivot = values.get(start)[1];
        int index = start;
        //
        for (int i = start + 1; i <= end; i++) {
            // 按照出现次数进行排列，出现次数最高的，所以 》的要进行 swap
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        // 在还回去
        Collections.swap(values, start, index);

        // 发现
        if (k <= index - start) {
            // 继续遍历左侧
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            // 找到了一部分了。
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            // 如果 k 还大于
            if (k > index - start + 1) {
                // 继续遍历
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
