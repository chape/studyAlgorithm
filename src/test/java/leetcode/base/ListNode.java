package leetcode.base;

/**
 * 单链表数据结构
 * Created by ChaoChao on 2018/10/25.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 生成1-num节点的单链表
     * @param num
     * @return
     */
    public static ListNode mockList(int num) {

        ListNode tail = null;
        ListNode head = null;
        for (int i = num; i > 0; i--) {
            head = new ListNode(i);
            head.next = tail;
            tail = head;
        }
        return head;
    }

    public static int size(ListNode head) {
        int size = 0;
        while (null != head) {
            head = head.next;
            size++;
        }
        return size;
    }
    public static void print(String info, ListNode head) {
        System.out.println(info);

        while (null != head) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

}
