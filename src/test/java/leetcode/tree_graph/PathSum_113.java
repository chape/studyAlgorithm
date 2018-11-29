package leetcode.tree_graph;

import leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by ChaoChao on 2018/11/3.
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 Note:  叶子节点是指没有子节点的节点。

 Example:


 给定如下二叉树，以及目标和 sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSum_113 {

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(8);
        TreeNode left11 = new TreeNode(11);
        TreeNode right11 = new TreeNode(13);
        TreeNode right12 = new TreeNode(4);
        TreeNode left31 = new TreeNode(7);
        TreeNode left32 = new TreeNode(2);
        TreeNode right31 = new TreeNode(5);
        TreeNode right32 = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        left1.left = left11;
        right1.left = right11;
        right1.right = right12;

        left11.left = left31;
        left11.right = left32;
        right12.left = right31;
        right12.right = right32;

        List<List<Integer>> result = pathSum(root, 22);

        Assert.assertNotEquals(0, result.size());
        for (List<Integer> ele : result) {
            int temp = 0;
            for (Integer e : ele) {
                temp += e;
            }
            Assert.assertEquals(22, temp);
        }

    }

    /**
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        preOrder(root,0,sum,result,stack);

        return result;
    }

    private void preOrder(TreeNode node, int pathValue , int sum, List<List<Integer>> result, Stack<Integer> stack) {
        if(null == node) {
            return;
        }

        pathValue += node.val;
        stack.push(node.val);

        if(null == node.left && null == node.right && pathValue == sum) {
            result.add(new ArrayList<>(stack));
        }
        preOrder(node.left,pathValue,sum,result,stack);
        preOrder(node.right,pathValue,sum,result,stack);

        pathValue -= node.val;
        stack.pop();
    }
}
