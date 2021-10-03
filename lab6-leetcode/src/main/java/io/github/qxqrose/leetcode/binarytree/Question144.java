package io.github.qxqrose.leetcode.binarytree;

import java.util.*;

/**
 * @author: qiu
 * 2021/8/11
 *
 * 二叉树的前序遍历
 */
public class Question144 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursionPreorder(list, root);
        return list;
    }

    /**
     * 递归 前序遍历
     * @param list
     * @param root
     */
    public void recursionPreorder(List<Integer> list, TreeNode root) {
        if(root != null) {
            list.add(root.val);
            recursionPreorder(list, root.left);
            recursionPreorder(list, root.right);
        }
    }

    /**
     * 迭代
     * @param list
     * @param root
     */
    public void iterationPreorder(List<Integer> list, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root != null) {
            stack.addLast(root);
        }

        while(!stack.isEmpty()) {
            TreeNode pop = stack.removeLast();
            list.add(pop.val);
            if(pop.right != null) {
                stack.addLast(pop.right);
            }
            if(pop.left != null) {
                stack.addLast(pop.left);
            }
        }
    }
}
