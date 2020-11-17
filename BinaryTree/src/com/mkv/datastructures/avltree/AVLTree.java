package com.mkv.datastructures.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {

	private AVLTreeNode<T> root;

	private void insert(T value) {
		root = insertInAVLTree(root, value);
	}

	private AVLTreeNode<T> insertInAVLTree(AVLTreeNode<T> currentNode, T value) {
    	if (currentNode == null) {
      		return new AVLTreeNode<>(value);
			}
		else if (currentNode.getData().compareTo(value) > 0) {
			currentNode.left = insertInAVLTree(currentNode.left, value);
		} else {
			currentNode.right = insertInAVLTree(currentNode.right, value);
		}
		int balance = checkBalance(currentNode.left, currentNode.right);
		//System.out.println("currentNode " + currentNode.getData() + "  balance " + balance +" ");

		if (balance > 1) {
			if (checkBalance(currentNode.left.left, currentNode.left.right) > 0)
				currentNode = rightRotate(currentNode); // Left - Left Condition
			else {
				currentNode.left = leftRotate(currentNode.left); // Left - Right Condition
				currentNode = rightRotate(currentNode);
			}
		} else if (balance < -1) {
			if (checkBalance(currentNode.right.right, currentNode.right.left) > 0) {
				currentNode = leftRotate(currentNode); // Right - Right Condition

			} else {
				currentNode.right = rightRotate(currentNode.right); // Right - Left Condition
				currentNode = leftRotate(currentNode);
			}
		}
		if (currentNode.left != null) {
			currentNode.left.setHeight(calculateHeight(currentNode.left));
		}
		if (currentNode.right != null) {
			currentNode.right.setHeight(calculateHeight(currentNode.right));
		}
		currentNode.setHeight(calculateHeight(currentNode));

		return currentNode;
	}

	private AVLTreeNode<T> rightRotate(AVLTreeNode<T> currentNode) {
		AVLTreeNode<T> newRoot = currentNode.left;
		currentNode.left = newRoot.right;
		newRoot.right = currentNode;
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}

	private AVLTreeNode<T> leftRotate(AVLTreeNode<T> currentNode) {
		AVLTreeNode<T> newRoot = currentNode.right;
		currentNode.right = newRoot.left;
		newRoot.left = currentNode;
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}

	private int calculateHeight(AVLTreeNode<T> node) {
		if (node == null) return 0;
		int leftSubTreeHeight = node.left != null ? node.left.getHeight() : -1;
		int rightSubTreeHeight = node.right != null ? node.right.getHeight() : -1;

		return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
	}

	private int checkBalance(AVLTreeNode<T> rootLeft, AVLTreeNode<T> rootRight) {
		// System.out.println("inside check balance ");
		if (rootLeft == null && rootRight == null) {
			// System.out.println("return 0 ");
			return 0;
		} else if (rootRight == null) {
			//	System.out.println("return rootLeft.getHeight() - -1 " + rootLeft.getHeight() + "  - " +
			// -1);
			return /*rootLeft.getHeight() + 1;*/ rootLeft.getHeight() - (-1);
		} else if (rootLeft == null) {
      /*System.out.println(
      					"return -1 - rootRight.getHeight() " + -1 + "  - " + rootRight.getHeight());
      */ return /*-1 * (rootRight.getHeight() + 1);*/ -1 - rootRight.getHeight();
		} else {
      /*System.out.println(
      					"rootLeft.getHeight() - rootRight.getHeight() " + rootLeft.getHeight() +"  - " + rootRight.getHeight());
      */ return rootLeft.getHeight() - rootRight.getHeight();
		}
	}

	private void levelOrderTraversal() {
		if (root != null) {
			Queue<AVLTreeNode<T>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				AVLTreeNode<T> presentNode = queue.poll();
				System.out.print(presentNode.getData() + "  ");
				if (presentNode.left != null) queue.add(presentNode.left);
				if (presentNode.right != null) queue.add(presentNode.right);
			}
		}
	}

	private AVLTreeNode<T> minimumElement(AVLTreeNode<T> root) {
		if (root.left == null) return root;
		return minimumElement(root.left);
	}

	public static void main(String[] args) {
		AVLTree<Integer> main = new AVLTree<>();

		main.insert(30);
		// System.out.println("------");
		System.out.print("1.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(20);
		System.out.print("2.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(40);
		System.out.print("3.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(10);
		System.out.print("4.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(5);
		System.out.print("5.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(3);
		System.out.print("6.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(4);
		System.out.print("7.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(50);
		System.out.print("8.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(60);
		System.out.print("9.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(70);
		System.out.print("10.) ");
		main.levelOrderTraversal();
		System.out.println();
		main.insert(65);
		System.out.print("11.) ");
		main.levelOrderTraversal();
		System.out.println();
	}
}
