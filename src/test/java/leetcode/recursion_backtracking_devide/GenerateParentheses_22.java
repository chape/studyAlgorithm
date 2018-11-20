package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses_22 {

    @Test
    public void testSubsetsWithDup() {

        List<String> result = generateParenthesis(3);

        for (String ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * 回溯法
     *
     * @param n 对括号
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate("",n,n,result);
        return result;
    }

    /**
     * 左括号要优先排列在右括号前面
     * @param item 符合的括号排列
     * @param left 左括号个数
     * @param right 右括号个数
     * @param list
     */
    private void generate(String item, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(item);
            return;
        }
        if(left > 0) {
            generate(item+"(", left-1,right,list);
        }
        if(left < right) {
            generate(item+")", left,right-1,list);
        }
    }
}
