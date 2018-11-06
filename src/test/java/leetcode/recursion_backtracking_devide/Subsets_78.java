package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets_78 {

    @Test
    public void testRemoveKdigits() {
        int[] nums = {1,2,3};

        List<List<Integer>> result = subsets0(nums);

        for (List ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * 回溯法 比如将元素1放入集合，则后续2、3，每次回溯放入和不放入(取出)过程
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        //添加空集
        set.add(subSet);
        //递归回溯 从数组第0个索引开始放入子集
        generate(0,nums,subSet,set);
        return set;
    }

    /**
     *
     * @param i 递归
     * @param nums 原数组
     * @param subSet 子集
     * @param set 总体集合
     */
    private void generate(int i, int[] nums, List<Integer> subSet, List<List<Integer>> set) {
        // 递归结束条件 超过元素索引
        if(i >= nums.length) {
            return;
        }
        subSet.add(nums[i]);
        set.add(new ArrayList<>(subSet));

        generate(i+1,nums,subSet,set);
        // 拿出上轮递归放入的元素
        subSet.remove(subSet.size() - 1);

        generate(i+1,nums,subSet,set);
    }

    /**
     * 位运算法 将1看作二进制001，2看作二进制010，3看作二进制100
     * 001 & 100 结果为0则不加入集合
     * 001 & 011 结果不为0则将1加入集合
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();

        int allSet = 1 << nums.length;
        // 如果nums数组元素个数为3，则从000 - 111遍历
        for (int i = 0; i < allSet; i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 将001、010、100分别从000 - 111遍历 结果不会0则加入集合
                if(0 != (i & (1 << j))) {
                    subSet.add(nums[j]);
                }
            }
            set.add(subSet);
        }
        return set;
    }

}
