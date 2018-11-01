package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * Created by ChaoChao on 2018/8/12.
 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL
 */
public class ReverseList_92 {

    @Test
    public void testReverseList() {

        ListNode head = ListNode.mockList(6);

        ListNode.print("反转前:", head);

        ListNode listNode = reverseBetween(head,1,2);

        ListNode.print("反转后:", listNode);

    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n < 0 || m < 0 || m >= n || null == head) {
            return head;
        }
        // 转置的节点数
        int reverseNum = n - m + 1;
        // 最终转置后链表的头结点
        ListNode result = head;

        // 逆置前开始节点的前驱节点
        ListNode beforeStart = null;
        // 逆置前开始节点
        ListNode start = null;
        // 逆置前尾节点
        ListNode tail = null;
        // 逆置前尾节点的后继节点
        ListNode tailAfter = null;

        // 找出逆置开始节点的前驱
        while (null != head && --m > 0) {
            beforeStart = head;
            head = head.next;
        }
        // 逆置前开始节点 也是逆置后的尾节点
        start = head;

        // 转置reverseNum个节点
        ListNode newHead = null;
        ListNode markHead = null;
        while (null != head && reverseNum > 0) {
            markHead = head.next;
            head.next = newHead;
            newHead = head;
            head = markHead;
            reverseNum--;
        }
        // 记录逆置前尾节点
        tail = newHead;
        // 记录逆置前尾节点的后继
        tailAfter = head;

        // 如果逆置前开始节点的前驱不为空 则将逆置前开始节点的前驱指向逆置前尾节点
        // 否则即从第一个节点开始逆置，逆置前尾节点为新头结点
        if(null != beforeStart) {
            beforeStart.next = tail;
        }else {
            result = tail;
        }
        // 逆置前开始节点指向逆置前尾节点的后继
        start.next = tailAfter;

        return result;
    }


}
