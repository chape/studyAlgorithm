package leetcode.easy.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ChaoChao on 2018/7/12.
 */
public class ArrayIntersect {

    @Test
    public void testIntersect() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        int[] result = intersect(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 || len2 == 0) {
            return new int[0];
        }
        int[] indexArray = new int[len1];
        int index = 0;
        OUT:
        for (int i = 0; i < len1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if(nums1[i] == nums2[j-1] && !contain(indexArray,j)) {
                    indexArray[index] = j;
                    index++;
                    continue OUT;
                }
            }
        }
        int[] result = new int[index];
        if(index == 0) {
            return result;
        }else {
            for (int i = 0; i < index; i++) {
                result[i] = nums2[indexArray[i]-1];
            }
        }
        return result;
    }

    private boolean contain(int[] nums, int ele) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == ele) {
                return true;
            }
        }
        return false;
    }
}
