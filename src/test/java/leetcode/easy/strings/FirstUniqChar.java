package leetcode.easy.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ChaoChao on 2018/7/18.
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.
 */
public class FirstUniqChar {

    @Test
    public void testRemoveDuplicates() {
        String str = "loveleetcode";
        int result = firstUniqChar(str);
        System.out.println(result);
    }

    public int firstUniqChar(String s) {
        if(null == s || s.length() == 0) {
            return -1;
        }
        if(s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {
                map.put(chars[i],map.get(chars[i]) + 1);
            }else {
                map.put(chars[i],1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i]) && map.get(chars[i]) >= 2) {
              continue;
            }
            return i;
        }
        return -1;
    }
}
