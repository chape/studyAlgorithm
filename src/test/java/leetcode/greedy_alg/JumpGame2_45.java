package leetcode.greedy_alg;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:

 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 说明:

 假设你总是可以到达数组的最后一个位置。
 */
public class JumpGame2_45 {

    @Test
    public void testRemoveKdigits() {
        int[] nums = {2,3,1,1,4};
        int result = jump(nums);
        Assert.assertEquals(2,result);
    }

    /**
     * 贪心(先将之前最大可跳索引记录下 直到遍历到遍历前所能跳跃的索引距离为止)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 小于2个元素的数组 不需要跳
        int len = nums.length;
        if(len < 2) {
            return 0;
        }
        //大于2个以上的元素 必定会跳一次
        int minJump = 1;
        // 先将之前最大可跳索引记录下 直到遍历到遍历前所能跳跃的索引距离为止
        int preMaxIndex = nums[0];
        int curMaxIndex = nums[0];
        for (int i = 0; i < len; i++) {
            if(i > curMaxIndex) {
                minJump++;
                curMaxIndex = preMaxIndex;
            }
            if(preMaxIndex < nums[i] + i) {
                preMaxIndex = nums[i] + i;
            }
        }

        return minJump;
    }
}
