package com.helloworld.demo.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionInvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();

                TreeNode temp = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = temp;

                if(currentNode.left != null) { queue.add(currentNode.left); }
                if(currentNode.right != null) { queue.add(currentNode.right); }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 5;
        tree.left.val = 4;
        tree.right.val = 3;
        System.out.println(SolutionInvertBinaryTree.invertTree(tree));
    }
}
