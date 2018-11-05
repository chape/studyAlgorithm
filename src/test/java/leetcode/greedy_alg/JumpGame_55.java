package leetcode.greedy_alg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置【可以跳跃的最大长度】。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGame_55 {

    @Test
    public void testRemoveKdigits() {
        int[] nums = {2,5,0,0};
        boolean result = canJump(nums);
        Assert.assertTrue(result);
    }

    /**
     * 贪心(当前索引位置i可跳的最远位置x，之后到达最远位置x时 继续搜寻此最远位置x可跳的最远位置y
     * 判断最终最远位置是否能超过数组最大索引)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int len = nums.length;
        // 构建索引位置可以跳至最远的索引位置 数组
        // nums = [2,3,1,1,4] 则 indexArr = [2,4,3,4,8]
        int[] indexArr = new int[len];
        for (int i = 0; i < len; i++) {
            indexArr[i] = i + nums[i];
        }
        // 遍历indexArr数组
        int jump = 0;
        // 在jump位置可跳最远距离maxIndex
        int maxIndex = indexArr[0];
        while (jump < len && jump <= maxIndex) {
            if(indexArr[jump] > maxIndex) {
                maxIndex = indexArr[jump];
            }
            jump++;
        }
        //当jump=len-1时 如果index[jump] 大于 maxIndex 则jump=len 即跳过数组
        if(jump == len) {
            return true;
        }
        return false;
    }
}
