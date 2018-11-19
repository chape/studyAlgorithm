package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.*;

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
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        list.add(subList);
        set.add(subList);
        generate(0, nums, new ArrayList<>(), list, set);
        return list;
    }

    private void generate(int index, int[] nums, List<Integer> subList, List<List<Integer>> list, Set<List<Integer>> set) {
        if(index >= nums.length) {
            return;
        }
        subList.add(nums[index]);
        if(!contain(subList,set)) {
            list.add(new ArrayList<>(subList));
            set.add(new ArrayList<>(subList));
        }
        generate(index+1, nums, subList, list, set);
        subList.remove(subList.size() - 1);
        generate(index+1, nums, subList, list, set);
    }

    private boolean contain(List<Integer> subSet, Set<List<Integer>> set) {
        int subSize = subSet.size();
        Collections.sort(subSet);
        for (List<Integer> ele : set) {
            if(ele.size() != subSize) {
                continue;
            }
            Collections.sort(ele);

            for (int i = 0; i < subSize; i++) {
                if(ele.get(i) != subSet.get(i)) {
                    break;
                }
                if(i == subSize-1 && ele.get(i) == subSet.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }

}
