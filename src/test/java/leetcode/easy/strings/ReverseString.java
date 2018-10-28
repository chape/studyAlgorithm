package leetcode.easy.strings;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/17.
 * 请编写一个函数，其功能是将输入的字符串反转过来。

 示例：

 输入：s = "hello"
 返回："olleh"
 */
public class ReverseString {

    @Test
    public void testRemoveDuplicates() {
        String s = "hello";
        String s1 = reverseString(s);
        System.out.println(s1);
    }

    public String reverseString(String s) {
        if(null == s || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int low = 0;
        int high = len-1;
        while (low < high){
            swap(chars,low,high);
            low++;
            high--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int index1, int index2){
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }


}
