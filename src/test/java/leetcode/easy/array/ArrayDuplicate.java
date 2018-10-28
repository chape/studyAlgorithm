package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChaoChao on 2018/7/12.
 存在重复
 给定一个整数数组，判断是否存在重复元素。

 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ArrayDuplicate {

    @Test
    public void testContainsDuplicate() {
        int[] nums = {1,2,3,1};
        Assert.assertEquals(true,containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> valueSet = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(valueSet.contains(nums[i])){
                return true;
            }
            valueSet.add(nums[i]);
        }
        return false;
    }
}
