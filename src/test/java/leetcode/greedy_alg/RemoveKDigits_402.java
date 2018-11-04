package leetcode.greedy_alg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

 注意:

 num 的长度小于 10002 且 ≥ k。
 num 不会包含任何前导零。
 示例 1 :

 输入: num = "1432219", k = 3
 输出: "1219"
 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 示例 2 :

 输入: num = "10200", k = 1
 输出: "200"
 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 示例 3 :

 输入: num = "10", k = 2
 输出: "0"
 解释: 从原数字移除所有的数字，剩余为空就是0。


 */
public class RemoveKDigits_402 {

    @Test
    public void testRemoveKdigits() {
        String num = "10200";
        int k = 1;
        String result = removeKdigits(num,k);
        System.out.println(result);
        Assert.assertEquals("200",result);
    }

    /**
     * 贪心(从高位开始遍历，如果前一个元素 比 后一个元素 大 则删除前一个元素)
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {

        char[] chars = num.toCharArray();
        int len = chars.length;

        // 每次栈顶元素 大于 字符串遍历元素 则弹出栈顶元素 push遍历元素
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() > chars[i] && k > 0) {
                stack.pop();
                k--;
            }
            if( chars[i] != '0' || !stack.isEmpty()) {
                stack.push(chars[i]);
            }
        }

        // 如果此时k还不为0，则弹出栈
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        // 遍历stack 返回最终字符串结果
        int resultLen = stack.size();
        char[] result = new char[resultLen];
        int index = resultLen-1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        String resultStr = new String(result);
        return "".equals(resultStr) ? "0" : resultStr;
    }
}
