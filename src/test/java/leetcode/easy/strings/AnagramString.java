package leetcode.easy.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaoChao on 2018/7/19.
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 */
public class AnagramString {

    @Test
    public void testRemoveDuplicates() {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));
    }

    public boolean isAnagram(String s, String t) {
        if(null == s && null == t) {
            return false;
        }
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        if(null == s || null == t || s.length() == 0 || t.length() == 0){
            return false;
        }
        char[] sChars = s.toCharArray();
        Map<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if(sMap.containsKey(sChars[i])) {
                sMap.put(sChars[i],sMap.get(sChars[i]) + 1);
            }else {
                sMap.put(sChars[i],1);
            }
        }

        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            if(sMap.containsKey(tChars[i])) {
                if(sMap.get(tChars[i]) == 1){
                    sMap.remove(tChars[i]);
                    continue;
                }
                sMap.put(tChars[i],sMap.get(tChars[i]) - 1);
            }else {
                return false;
            }
        }
        if(sMap.size() == 0) {
            return true;
        }
        return false;
    }
}
