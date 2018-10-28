package leetcode.easy.strings;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/7/22.
 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 */

public class IndexStr {

    @Test
    public void testRemoveDuplicates() {
//        String haystack = "mississippi";
        String haystack = "hello";
//        String needle = "issip";
        String needle = "ll";
        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
