package com.mkv.datastructures.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T> {

	private AVLTreeNode<T> root;

	private void rightRotate(AVLTreeNode<T> node) {
	}

	private int calculateHeight(AVLTreeNode<T> node) {
		if(node == null)
			return 0;
		int leftSubTreeHeight = node.left != null ? node.left.getHeight() : -1;
		int rightSubTreeHeight = node.right != null ? node.right.getHeight() : -1;

		return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
	}

	private int checkBalance(AVLTreeNode<T> rootLeft, AVLTreeNode<T> rootRight) {

		if(rootLeft == null && rootRight == null)
			return 0;
		else if(rootRight == null)
			return rootLeft.getHeight() - (-1);
		else if(rootLeft == null)
			return -1 - rootRight.getHeight();
		else
			return rootLeft.getHeight() - rootRight.getHeight();
	}

	private void levelOrderTraversal() {
		if(root != null) {
			Queue<AVLTreeNode<T>> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				AVLTreeNode<T> presentNode = queue.poll();
				System.out.print(presentNode.getData());
				if(presentNode.left != null)
					queue.add(presentNode.left);
				if(presentNode.right != null)
					queue.add(presentNode.right);

			}
		}
	}
}
