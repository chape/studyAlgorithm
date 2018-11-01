package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.*;


/**
 * Created by ChaoChao on 2018/10/31.
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 输出: 1->1->2->3->4->4->5->6
 */
public class MergeList_23 {

    @Test
    public void testPartition() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        c1.next = c2;

        ListNode result = mergeKLists1(Arrays.asList(a1,b1,c1).toArray(new ListNode[0]));
        ListNode.print("合并后的列表", result);
    }

    /**
     * 分治法(归并)
     * @param lists
     * @return
     */
    public ListNode mergeKLists0(ListNode[] lists) {
        return helper(lists,0,lists.length-1);
    }

    private ListNode helper(ListNode[] lists, int low, int high) {
        if(low == high) {
            return lists[low];
        }
        //分治
        int mid = low + (high - low)/2;
        ListNode leftNodes = helper(lists, low, mid);
        ListNode rightNodes = helper(lists,mid + 1,high);
        //合并
        return mergeTwo(leftNodes,rightNodes);

    }

    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (null != list1 && null != list2) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (null != list1) {
            temp.next = list1;
        }
        if (null != list2) {
            temp.next = list2;
        }
        return dummy.next;
    }

    /**
     * 两两合并法
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(null == lists || lists.length == 0) {
            return null;
        }

        int interval = 1;
        int length = lists.length;
        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval*2) {
                lists[i] = mergeTwoList1(lists[i],lists[interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoList1(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoList1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList1(l1,l2.next);
            return l2;
        }

    }

    /**
     * 最小堆
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (int i = 0; i < lists.length; i++) {
            if(null != lists[i]) {
                queue.add(lists[i]);
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(null != node.next) {
                queue.add(node.next);
            }
            temp.next = node;
            temp = node;
        }
        return newHead.next;
    }

}
