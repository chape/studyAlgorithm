package leetcode.easy.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ChaoChao on 2018/7/11.
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]

 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class RotateArray {

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {1,2,3,4,5,6,7};
        rotate5(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     *
     */
    public void rotate5(int nums[], int k) {
        int n = nums.length;
        k=k%n;
        for (int start=0; start<nums.length && k!=0 ; k = k%n){
            for (int i = 0; i < k; i++) {
                swap(nums, start+i, nums.length-k+i);
            }
            n=n-k;
            start=start+k;
        }
    }

    /**
     * 类似翻转字符的方法，思路是先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int len = nums.length;
        if(len <= 1) {
            return;
        }
        k %= len;
        if(k == 0) {
            return;
        }
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 借用变量实现空间复杂度O(1)
     * i 旋转k位后映射位置: (i+k)%len
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        if(len <= 1) {
            return;
        }
        k %= len;
        if(k == 0) {
            return;
        }

        int n = nums.length, start = 0, i = 0, cur = nums[i], cnt = 0;
        while (cnt++ < n) {
            i = (i + k) % n;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start; ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }
    /**
     * 空间复杂度为O(N) 不过思路不错
     * i 旋转k位后映射位置: (i+k)%len
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] cpNums = Arrays.copyOf(nums, len);
        for(int i=0; i<len; i++) {
            nums[(i+k)%len] = cpNums[i];
        }
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        for(int i=0; i<k; i++) {
            int last = nums[len - 1];
            for(int j=len-1; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}
