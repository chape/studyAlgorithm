package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ChaoChao on 2018/10/28.
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

 说明：不允许修改给定的链表。

 进阶：
 你是否可以不用额外空间解决此题？
 */
public class CircleList_142 {

    @Test
    public void testDetectCycle() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;

        ListNode result = detectCycle0(a1);
        if(null != result){
            System.out.println("入环节点:" + result.val);
            return;
        }
        System.out.println("不存在环");

    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle0(ListNode head) {
        if(null == head || null == head.next) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 使用SET
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (null != head) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

}