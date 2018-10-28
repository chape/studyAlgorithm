package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;


/**
 * Created by ChaoChao on 2018/8/12.
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {

    @Test
    public void testDeleteNode() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(9);
        node3.next = node4;

        print(node1);
        deleteNode(node2);
        print(node1);

    }

    public void deleteNode(ListNode node) {
        if(null != node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    private void print(ListNode node) {
        while(null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}
