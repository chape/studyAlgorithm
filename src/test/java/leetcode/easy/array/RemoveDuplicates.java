package leetcode.easy.array;

import org.junit.Test;

/**
 * Created by ChaoChao on 11/07/2018.
 从排序数组中删除重复项
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int size = removeDuplicates(nums);
        System.out.println("不重复元素个数:"+size);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[index] > 0){
                index++;
                nums[index] = nums[i];
            }

        }
        return index+1;
    }
}
