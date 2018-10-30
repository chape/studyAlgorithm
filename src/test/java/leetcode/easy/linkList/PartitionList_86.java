package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ChaoChao on 2018/10/28.
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例:

 输入: head = 1->4->3->2->5->2, x = 3
 输出: 1->2->2->4->3->5
 */
public class PartitionList_86 {

    @Test
    public void testPartition() {

//        ListNode a1 = new ListNode(2);
//        ListNode a2 = new ListNode(1);
//        a1.next = a2;

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        ListNode result = partition0(a1, 3);
        ListNode.print("分隔后的列表", result);
    }

    /**
     * 临时头节点
     * @param head
     * @return
     */
    public ListNode partition0(ListNode head, int x) {

        ListNode lessHead = new ListNode(0);
        ListNode lessPt = lessHead;

        ListNode moreHead = new ListNode(0);
        ListNode morePt = moreHead;

        while (null != head) {
            if(head.val < x) {
                lessPt.next = head;
                lessPt = head;
            } else {
                morePt.next = head;
                morePt = head;
            }
            head = head.next;
        }

        morePt.next = null;
        //小于x的【头指针】 指向 大于x的【头结点】的下一个节点
        lessPt.next = moreHead.next;

        return lessHead.next;
    }
    /**
     * 双队列
     * @param head
     * @return
     */
    public ListNode partition1(ListNode head, int x) {

        Queue<ListNode> maxQ = new LinkedList<>();
        Queue<ListNode> minQ = new LinkedList<>();
        ListNode newHead = null;
        while (null != head) {
            if(head.val < x) {
                minQ.add(head);
            } else {
                maxQ.add(head);
            }
            head = head.next;
        }
        boolean hasFirst = false;
        ListNode dummy = new ListNode(0);
        while (!minQ.isEmpty()) {
            ListNode ele = minQ.poll();
            if(!hasFirst) {
                newHead = ele;
                hasFirst = true;
            }
            dummy.next = ele;
            dummy = ele;
        }
        while (!maxQ.isEmpty()) {
            ListNode ele = maxQ.poll();
            if(!hasFirst) {
                newHead = ele;
                hasFirst = true;
            }
            dummy.next = ele;
            dummy = ele;
        }
        dummy.next = null;
        return newHead;
    }

}