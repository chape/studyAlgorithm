package leetcode.greedy_alg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ChaoChao on 2018/11/3.
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。

 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

 Example:

 输入:
 [[10,16], [2,8], [1,6], [7,12]]

 输出:
 2

 解释:
 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）
 */
public class BurstBalloon_452 {

    @Test
    public void testRemoveKdigits() {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};

        int result = findMinArrowShots(points);
        Assert.assertEquals(2,result);
    }

    /**
     * 贪心(按气球开始坐标排序)
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(0 == len) {
            return 0;
        }
        //先按气球开始坐标排序
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int shootNum = 1;
        int shootStart = points[0][0];
        int shootEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= shootEnd ) {
                shootStart = points[i][0];
                if(shootEnd > points[i][1]) {
                    shootEnd = points[i][1];
                }
            } else {
                shootNum++;
                shootStart = points[i][0];
                shootEnd = points[i][1];
            }
        }
        return shootNum;
    }

    private void sort(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < points.length-i; j++) {
                if(points[j][0] < points[j-1][0]) {
                    int[] temp = points[j-1];
                    points[j-1] = points[j];
                    points[j] = temp;
                }
            }
        }
    }
}
