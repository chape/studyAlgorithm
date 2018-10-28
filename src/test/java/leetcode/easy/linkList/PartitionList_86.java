package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
    public void testHasCycle() {

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

        ListNode result = partition(a1, 3);
        ListNode.print("分隔后的列表", result);
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        return null;
    }

}