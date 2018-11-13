package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.List;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
 [1,2,2],
 [5]
 ]
 */
public class CombinationSum2_40 {

    @Test
    public void testSubsetsWithDup() {
        int[] nums = {2,5,2,1,2};
        int target = 5;

        List<List<Integer>> result = combinationSum2(nums, target);

        for (List ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * 回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }


}
