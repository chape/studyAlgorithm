package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * Created by ChaoChao on 2018/8/12.
 * 反转一个单链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList_206 {

    @Test
    public void testReverseList() {

        ListNode head = ListNode.mockList(5);

        ListNode.print("反转前:", head);

        ListNode listNode = reverseList4(head);

        ListNode.print("反转后:", listNode);

    }

    /**
     * 迭代法 就地逆置
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }

        ListNode newHead = null;

        while (null != head) {
            // 翻转前 备份翻转节点的下一个节点
            ListNode markNode = head.next;
            // 翻转
            head.next = newHead;
            // 移动节点 等待下一轮循环翻转
            newHead = head;
            head = markNode;
        }

        return newHead;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if(null == head || null == head.next) {
            return head;
        }
        /**
         * 1-2-3
         * reverseList3(3) return 3
         *
         * reverseList3(2)
         * 2.next.next = 2; 2.next = null; 即3-2-null
         *
         * reverseList3(1)
         * 1.next.next = 1; 1.next = null; 即2-1-null
         *
         * 即3-2-1 返回newHead 3
         */
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (null != head) {
            ListNode next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }

        return temp.next;
    }

    /**
     * 三指针法
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {

        if(null == head) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        if (null == fast) {
            return head;
        }

        ListNode temp;
        head.next = null;
        while (null != fast.next) {
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        fast.next = slow;

        return fast;
    }

    /**
     * 插入法
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {

        ListNode first = head.next;
        ListNode second;
        while (null != first.next) {
            second = first.next;
            first.next = second.next;
            second.next = head.next;
            head.next = second;
        }

        first.next = head;
        head = head.next;
        first.next.next = null;

        return head;
    }


}
