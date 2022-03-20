package again;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


// 回溯，减枝，不重复
class Solution {
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        // target list -
        dfs(candidates,target,list,0);
        return res;
    }
    //数组nums和目标值target是肯定需要传入的两个参数
    //为了方便list加入数字也传入
    //添加nowposition是运行代码后，发现‘[2，2，3]，[2,3,2],[3,2,2]这样的组合
    //需要进行剪枝，但如何能更便捷间枝，需要在for循环中进行处理

    public void dfs(int[] nums,int target,List<Integer> list,int nowposition){
        //1.截止条件
        // 错误终止条件
        if(target <0 ) {
            return;
        }
        // 正常的终止条件
        if(target==0){
            res.add(new ArrayList(list));
            return;
        }
        //2.所有候选元素
        for(int i=nowposition;i<nums.length;i++){
            // 选择所有的节点
            list.add(nums[i]);
            //3.进行剪枝
            //这里添加i作为参数进入是点睛之笔，也就是说，每次for循环开始只能从nowposition开始
            //这里意味着，2，3，6，7这个数组，如果已经循环到3，就只能从3开始循环后面元素，不会重复2
            //这样就实现了剪枝
            dfs(nums,target-nums[i],list,i);
            list.remove(list.size()-1);
        }
        return;
    }
}
