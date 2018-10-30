package leetcode.easy.linkList;

import leetcode.base.RandomListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaoChao on 2018/10/28.
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

 要求返回这个链表的深度拷贝。
 */
public class RandomList_138 {

    @Test
    public void testCopyRandomList() {

        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        a1.random = a3;
        a2.random = a4;
        a3.random = a3;
        a4.random = null;
        a5.random = a4;

        RandomListNode result = copyRandomList(a1);
    }

    /**
     * 老节点-老节点位置
     * 新节点位置-新节点
     * 新老节点位置索引相同
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode oldHead = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy;

        Map<RandomListNode,Integer> oldNodeIndex = new HashMap<>();
        Map<Integer,RandomListNode> newIndexNode = new HashMap<>();

        int index = 0;
        while (null != head) {
            //复制新链表的向后指向
            RandomListNode x = new RandomListNode(head.label);
            dummy.next = x;
            dummy = x;

            //老节点-老节点位置
            oldNodeIndex.put(head,index);
            //新节点位置-新节点
            newIndexNode.put(index,x);

            head = head.next;
            index++;
        }

        RandomListNode result = newHead.next;
        newHead = newHead.next;

        //复制新节点随机指针指向
        while (null != oldHead) {
            RandomListNode random = oldHead.random;
            Integer indexNum = oldNodeIndex.get(random);
            newHead.random = newIndexNode.get(indexNum);
            newHead = newHead.next;
            oldHead = oldHead.next;
        }

        return result;
    }

}