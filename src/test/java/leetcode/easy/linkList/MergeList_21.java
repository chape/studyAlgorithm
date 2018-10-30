package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * Created by ChaoChao on 2018/10/31.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeList_21 {

    @Test
    public void testPartition() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        ListNode result = mergeTwoLists(a1, b1);
        ListNode.print("合并后的列表", result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;
    }

}
