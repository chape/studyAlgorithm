package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.List;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets2_90 {

    @Test
    public void testSubsetsWithDup() {
        int[] nums = {1,2,2};

        List<List<Integer>> result = subsetsWithDup(nums);

        for (List ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }

}
