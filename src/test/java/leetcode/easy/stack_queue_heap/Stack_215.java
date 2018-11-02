package leetcode.easy.stack_queue_heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ChaoChao on 2018/11/3.
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Stack_215 {

    @Test
    public void testFindKthLargest() {
        int[] nums = {3,2,1,5,6,4};
        int result = findKthLargest0(nums, 2);
        Assert.assertEquals(result,5);
    }

    /**
     * 元素为k的最小堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest0(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1,e2) -> e1-e2);
        for (int i = 0; i < nums.length; i++) {
            if(minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if(minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        return minHeap.peek();
    }
    /**
     * 将nums组织为最大堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1,e2) -> e2-e1);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int result = 0;
        while (k > 0) {
            result = maxHeap.poll();
            k--;
        }
        return result;
    }
}
