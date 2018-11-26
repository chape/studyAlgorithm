package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

 示例:

 输入: [5,2,6,1]
 输出: [2,1,1,0]
 解释:
 5 的右侧有 2 个更小的元素 (2 和 1).
 2 的右侧仅有 1 个更小的元素 (1).
 6 的右侧有 1 个更小的元素 (1).
 1 的右侧有 0 个更小的元素.
 */
public class SmallAfterSelf_315 {

    @Test
    public void testSolveNQueens() {

        int[] nums = {5,2,6,1};
        List<Integer> result = countSmaller(nums);

        result.forEach(System.out::print);
    }

    /**
     * 分治-归并
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {

        int len = nums.length;
        int[] count = new int[len];
        // 记录数值-索引
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Pair pair = new Pair(nums[i], i);
            pairs.add(pair);
        }

        mergeSort(pairs,count);

        return Arrays.stream(count).mapToObj(e -> new Integer(e)).collect(Collectors.toList());
    }

    private void mergeSort(List<Pair> pairs, int[] count) {
        int len = pairs.size();
        if(len < 2) {
            return;
        }
        // 分治
        int mid = len / 2;
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(pairs.get(i));
        }
        for (int i = mid; i < len; i++) {
            right.add(pairs.get(i));
        }
        // 递归子问题
        mergeSort(left,count);
        mergeSort(right,count);

        pairs.clear();
        mergeTwo(left,right,pairs,count);
    }

    private void mergeTwo(List<Pair> left, List<Pair> right, List<Pair> pairs, int[] count) {
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            // 左右元素比较
            if(left.get(leftIndex).value <= right.get(rightIndex).value) {
                // 左节点插入时，count元素值 = 左节点索引在count数组的元素 + 右节点索引
                count[left.get(leftIndex).index] += rightIndex;
                pairs.add(left.get(leftIndex));
                leftIndex++;
            } else {
                pairs.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        for (; leftIndex < left.size(); leftIndex++) {
            // 左节点插入时，count元素值 = 左节点索引在count数组的元素 + 右节点索引
            count[left.get(leftIndex).index] += rightIndex;
            pairs.add(left.get(leftIndex));
        }
        for (; rightIndex < right.size(); rightIndex++) {
            pairs.add(right.get(rightIndex));
        }
    }

    /**
     * 值-索引
     */
    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
