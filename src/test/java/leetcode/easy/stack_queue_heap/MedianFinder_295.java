package leetcode.easy.stack_queue_heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by ChaoChao on 2018/11/3.
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

 例如，

 [2,3,4] 的中位数是 3

 [2,3] 的中位数是 (2 + 3) / 2 = 2.5

 设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。
 示例：

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
 进阶:

 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder_295 {

    @Test
    public void testAddNum() {
        MedianFinder_295 medianFinder = new MedianFinder_295();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        Assert.assertEquals(1.5d,medianFinder.findMedian(),0.01d);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        Assert.assertEquals(2.0d,medianFinder.findMedian(),0.01d);
    }

    /**
     * 可以想象，将所有元素排序
     * 最大堆存前N/2个数，堆顶为前N/2最大数
     * 最小堆存后N/2个数，堆顶为后N/2最小数
     * 最大堆比最小堆元素个数多 则最大堆堆顶即为中位数
     * 最小堆比最大堆元素个数多 则最小堆堆顶即为中位数
     * 最小堆和最大堆元素个数相同 则(最小堆堆顶 + 最小堆堆顶)/2 即为中位数
     */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder_295() {
        minHeap = new PriorityQueue<>((e1,e2) -> e1-e2);
        maxHeap = new PriorityQueue<>((e1,e2) -> e2-e1);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        // 元素个数 最大堆 == 最小堆
        if(minHeap.size() == maxHeap.size()) {
            if(maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        // 元素个数 最大堆 > 最小堆
        } else if(maxHeap.size() > minHeap.size()) {
            if(maxHeap.peek() < num) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        // 元素个数 最大堆 < 最小堆
        } else if(minHeap.size() > maxHeap.size()) {
            if(minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }


    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())*1.0/2;
        }
        return minHeap.peek();
    }
}
