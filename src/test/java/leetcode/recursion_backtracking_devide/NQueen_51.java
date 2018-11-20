package leetcode.recursion_backtracking_devide;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaoChao on 2018/11/3.
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。

 */
public class NQueen_51 {

    @Test
    public void testSolveNQueens() {

        List<List<String>> result = solveNQueens(4);

        for (List<String> ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * 回溯法
     *
     * @param n 对括号
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        return null;
    }
}
