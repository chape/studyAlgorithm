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
     * @param n 棋盘带下
     * @return
     */
    public List<List<String>> solveNQueens(int n) {

        // 初始化
        // 存放最终结果
        List<List<String>> result = new ArrayList<>();
        char[][] location = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                location[i][j] = '.';
            }
        }
        int[][] markBoard = new int[n][n];

        generate(0, n, location, result, markBoard);
        return result;

    }

    /**
     * 每一行放置皇后
     * @param k 第几次放置
     * @param n 棋盘大小
     * @param location 子结果
     * @param result 最终结果
     * @param markBoard 标记不能放置皇后
     */
    private void generate(int k, int n, char[][] location, List<List<String>> result, int[][] markBoard) {

        // 存放子结果
        if(k == n) {
            List<String> locationStr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                locationStr.add(String.valueOf(location[i]));
            }
            result.add(locationStr);
            return;
        }

        // 从0到N-1列遍历尝试放置皇后
        for (int i = 0; i < n; i++) {
            // 不为0 则放置
            if(markBoard[k][i] == 0) {
                // 记录回溯前的标记情况
                int[][] tmpMark = deepCopy(markBoard);
                location[k][i] = 'Q';
                // 放置皇后后设置标记
                putDownQueue(markBoard,k,i);
                //进入下一行
                generate(k+1,n,location,result,markBoard);
                // 恢复回溯前标记
                markBoard = tmpMark;
                //把之前尝试标记为皇后的坐标置为.
                location[k][i] = '.';
            }
        }
    }

    /**
     * 放下皇后 标记棋盘上所有不能再放皇后的坐标
     * @param markBoard
     * @param x
     * @param y
     */
    private void putDownQueue(int[][] markBoard, int x, int y) {
        int len = markBoard.length;
        // 上竖直 上右斜 右 下右斜 下竖直 下左斜 左 左上斜 八个方向(x,y坐标，xy一一对应)
        int[] dx = {-1,0,1,1,1,0,-1,-1};
        int[] dy = {1,1,1,0,-1,-1,-1,0};
        markBoard[x][y] = 1;
        // 每个方向向外延伸 从1到N-1距离
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 8; j++) {
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                // 是否在棋盘内
                if(newX >= 0 && newX < len && newY >= 0 && newY < len) {
                    markBoard[newX][newY] = 1;
                }
            }
        }
    }

    /**
     * 二维数组深拷贝
     * @param markBoard
     * @return
     */
    private int[][] deepCopy(int[][] markBoard){
        int len = markBoard.length;
        int[][] copy = new int[len][];
        for (int i = 0; i < len; i++) {
            copy[i] = markBoard[i].clone();
        }
        return copy;
    }

}
