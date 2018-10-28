package leetcode.easy.strings;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/18.
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 */
public class ReverseInt {

    @Test
    public void testRemoveDuplicates() {
        int num = 1534236469;
        int result = reverse(num);
        System.out.println(result);
    }

    public int reverse(int x) {
        int base = 10;
        int count = 0;
        int[] reverseArray = new int[10];
        boolean pFlag = true;
        if(x < 0) {
            pFlag = false;
            x *= -1;
        }
        while(x % base != 0 || x / base != 0){
            reverseArray[count] = x % base;
            x /= base;
            count++;
        }
        int result = 0;

        for (int i = 0; i < count; i++) {
            int temp = 1;
            int inner = count - i;
            while (inner>1) {
                temp *= base;
                inner--;
            }
            result += reverseArray[i] * temp;
            if(0 != result && result < temp) {
                return 0;
            }
        }
        if(pFlag) {
            return result;
        }
        return result * -1;
    }

    private void swap(char[] chars, int index1, int index2){
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

}
