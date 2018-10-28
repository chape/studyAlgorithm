package leetcode.easy.strings;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/19.
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 */
public class PalindromeString {

    @Test
    public void testRemoveDuplicates() {
        String s = "ab2a";

        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if(null == s || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;

        while (low < high){
            if((chars[low] < '0' || chars[low] > '9') && (chars[low] < 'A' || chars[low] > 'Z') && (chars[low] < 'a' || chars[low] > 'z')){
                low++;
                continue;
            }
            if((chars[high] < '0' || chars[high] > '9') && (chars[high] < 'A' || chars[high] > 'Z') && (chars[high] < 'a' || chars[high] > 'z')){
                high--;
                continue;
            }
            if(chars[low] == chars[high]) {
                low++;
                high--;
                continue;
            }
            if(chars[low] > chars[high] && chars[low] - 32 == chars[high]) {
                if((chars[low] >= '0' && chars[low] <= '9') || (chars[high] >= '0' && chars[high] <= '9')){
                    return false;
                }
                low++;
                high--;
                continue;
            }
            if(chars[low] < chars[high] && chars[high] - 32 == chars[low]) {
                if((chars[low] >= '0' && chars[low] <= '9') || (chars[high] >= '0' && chars[high] <= '9')){
                    return false;
                }
                low++;
                high--;
                continue;
            }
            return false;
        }
        return true;
    }
}
