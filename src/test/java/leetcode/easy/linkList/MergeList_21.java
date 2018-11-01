package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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

        ListNode result = mergeTwoList1(a1, b1);
        ListNode.print("合并后的列表", result);
    }

    /**
     * 临时头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode pre = tempHead;

        while (null != l1 && null != l2) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(null != l1) {
            pre.next = l1;
        }
        if(null != l2) {
            pre.next = l2;
        }

        return tempHead.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList1(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }
        if(l1.val < l2.val) {
            // 把链表1除去比链表2的节点看成新的链表1 与 链表2 合并
            // 再将之前链表1除去的节点指向新的合并链表
            // 最后返回除去的节点作为头结点
            l1.next = mergeTwoList1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList1(l1,l2.next);
            return l2;
        }

    }

    /**
     * 线性表排序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList2(ListNode l1, ListNode l2) {

        if(null == l1) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }

        List<ListNode> list = new ArrayList<>();

        while (null != l1 && null != l2) {
            if(l1.val > l2.val) {
                list.add(l2);
                l2 = l2.next;
            } else {
                list.add(l1);
                l1 = l1.next;
            }
        }
        ListNode head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list.get(i-1).next = list.get(i);
        }
        if (null != l1) {
            list.get(list.size() - 1).next = l1;
        }
        if (null != l2) {
            list.get(list.size() - 1).next = l2;
        }

        return head;
    }

}
