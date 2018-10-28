package leetcode.easy.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaoChao on 11/07/2018.
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Sum2 {
    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length-1; i++) {
            int one = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int two = target - one;
                if(nums[j] == two) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if(nums == null) {
            return new int[]{-1,-1};
        }
        int[] result = new int[]{-1,-1};
        Map<Integer,Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(target - nums[i])) {
                return new int[]{i,valueIndexMap.get(target - nums[i])};
            }
            valueIndexMap.put(nums[i],i);
        }
        return result;
    }
}
