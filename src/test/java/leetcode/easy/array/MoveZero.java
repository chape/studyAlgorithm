package leetcode.easy.array;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/13.
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 */
public class MoveZero {
    @Test
    public void testRemoveDuplicates() {
        int[] prices = {0,1,0,3,12};
        moveZeroes(prices);
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return;
        }
        int size = len;
        for (int i = 0; i < len; i++) {
            if(nums[size-1] == 0) {
                size = size - 1;
                continue;
            } else {
                moveRound(nums,size);
            }
        }
    }

    private void moveRound(int[] nums,int size) {
        if(size - 1 < 1) {
            return;
        }
        int temp = nums[size-1];
        for (int i = size -1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
    }
}
