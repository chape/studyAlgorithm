package leetcode.easy.linkList;

import leetcode.base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ChaoChao on 2018/10/28.
 * 编写一个程序，找到两个单链表相交的起始节点。(则最后一个节点必相同)

 例如，下面的两个链表：

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 在节点 c1 开始相交。

 注意：

 如果两个链表没有交点，返回 null.
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode_160 {

    @Test
    public void testReverseList() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        b1.next = c1;

        ListNode intersectionNode = getIntersectionNode0(a1, b1);
        if(null == intersectionNode){
            System.out.println("不相交");
            return;
        }
        System.out.println(intersectionNode.val);

    }

    /**
     * 让链表长的先走sizeA-sizeB步 然后再一起走
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {

        if(null == headA || null == headB) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }

        ListNode aNode = headA;
        ListNode bNode = headB;
        int sizeA = 0;
        while (null != aNode) {
            aNode = aNode.next;
            sizeA++;
        }
        int sizeB = 0;
        while (null != bNode) {
            bNode = bNode.next;
            sizeB++;
        }

        int gap = 0;
        if(sizeA > sizeB) {
            aNode = headA;
            bNode = headB;
            gap = sizeA - sizeB;
            while (gap > 0) {
                aNode = aNode.next;
                gap--;
            }
            while (aNode != bNode) {
                aNode = aNode.next;
                bNode = bNode.next;
            }
            if (null == aNode || null == bNode) {
                return null;
            }
            return aNode;
        }

        aNode = headA;
        bNode = headB;
        gap = sizeB - sizeA;
        while (gap > 0) {
            bNode = bNode.next;
            gap--;
        }
        while (aNode != bNode) {
            aNode = aNode.next;
            bNode = bNode.next;
        }
        if (null == aNode || null == bNode) {
            return null;
        }
        return bNode;
    }

    /**
     * 使用SET
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }
        ListNode aNode = headA;
        ListNode bNode = headB;
        Set<ListNode> setA = new HashSet<>();
        while (null != aNode) {
            setA.add(aNode);
            aNode = aNode.next;
        }
        while (null != bNode) {
            if(setA.contains(bNode)) {
                return bNode;
            }
            bNode = bNode.next;
        }
        return null;

    }
    /**
     * 使用栈
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(null == headA || null == headB) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }

        Stack<ListNode> stackA = new Stack<>();
        ListNode aNode = headA;
        ListNode bNode = headB;
        while (null != aNode) {
            stackA.push(aNode);
            aNode = aNode.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        while (null != bNode) {
            stackB.push(bNode);
            bNode = bNode.next;
        }
        if(stackA.peek() != stackB.peek()) {
            return null;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty() && aNode == bNode) {
            aNode = stackA.pop();
            bNode = stackB.pop();
        }
        if(aNode == bNode) {
            return aNode;
        }
        return aNode.next;
    }
}