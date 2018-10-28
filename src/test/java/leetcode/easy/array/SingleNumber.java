package leetcode.easy.array;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/12.
 只出现一次的数字
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 示例 1:

 输入: [2,2,1]
 输出: 1
 */
public class SingleNumber {

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {1,1,2};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    /**
     * 把数组中所有的数字都异或起来，则每对相同的数字都会得0，然后最后剩下来的数字就是那个只有1次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            result ^= nums[i];
        }
        return result;
    }
}
