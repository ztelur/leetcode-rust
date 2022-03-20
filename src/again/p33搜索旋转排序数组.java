package again;


/**
 * 这启示我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
 *
 *
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        // 进行二分查找，所以一定是有 l 和 r 的
        while (l <= r) {
            // 取 中间值
            int mid = (l + r) / 2;
            // 相等，则直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 前半段是有序的
            if (nums[0] <= nums[mid]) {
                // 说明 target 是在这边有序的地方的，则收缩右侧边界
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    //
                    l = mid + 1;
                }
            } else {
                // 如果是后半段是有序的
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
