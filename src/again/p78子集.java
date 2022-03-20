package again;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), new ArrayList<>());
        return ret;
    }
    private void backtracking(int[] nums, int index, List<Integer> itrList, List<List<Integer>> retList) {
        if (index >= nums.length) {
            retList.add(itrList);
        }

        backtracking(nums, index + 1, itrList, retList);
        itrList.add(nums[index]);
        backtracking(nums, index + 1, itrList, retList);
        itrList.remove(index);
    }
}
