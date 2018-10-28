package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * Created by ChaoChao on 2018/8/12.
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    @Test
    public void testDeleteNode() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        print(head);
        ListNode resultHead = removeNthFromEnd(head, 1);
        print(resultHead);

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head,fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(null == fast) {
            return head.next;
        }
        while(null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    private void print(ListNode node) {
        while(null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}
