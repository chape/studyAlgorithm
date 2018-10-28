package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ChaoChao on 2018/10/28.
 * 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 */
public class CircleList_141 {

    @Test
    public void testHasCycle() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;

        boolean b = hasCycle1(a1);
        if(b){
            System.out.println("存在环");
            return;
        }
        System.out.println("不存在环");

    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle0(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用SET
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (null != head) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}