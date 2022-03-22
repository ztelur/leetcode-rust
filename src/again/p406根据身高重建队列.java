
class Solution {
    public int[][] reconstructQueue(int[][] people) {


        // 排序
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                // 先按照身高排序,不行在按照前边的人进行排序，保证相对顺序
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });


        int n = people.length;


        int[][] ans = new int[n][];

        // 遍历所有的人，会从低到高进行排序
        for (int[] person : people) {
            // 查看它前边有多少人，最小的，所以不可能有小于它的，所以它前边的空位是真实的。
            int spaces = person[1] + 1;
            //
            for (int i = 0; i < n; ++i) {
                // 如果这个位置为null，还是空的
                if (ans[i] == null) {
                    // 那么就进行减
                    --spaces;
                    // 等到为0时，就将其安排到该位置。
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}