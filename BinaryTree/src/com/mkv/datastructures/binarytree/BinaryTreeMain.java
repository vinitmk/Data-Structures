package com.mkv.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeMain<T> {

	private BinaryTreeNode<T> root;

	private void insert(T num) {
		if (root == null) {

			root = new BinaryTreeNode<>(num);

		} else {
			Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> node = queue.poll();
				if (node.left == null) {

					node.left = new BinaryTreeNode<>(num);
					break;
				} else if (node.right == null) {

					node.right = new BinaryTreeNode<>(num);
					break;
				} else {
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
	}

	private void print() {
		printPreorder(root);
		System.out.println();
		printInorder(root);
		System.out.println();
		printPostorder(root);
		System.out.println();
		printLevelOrder(root);
		System.out.println();
	}

	private void printInorder(BinaryTreeNode<T> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	private void printPreorder(BinaryTreeNode<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printInorder(root.left);
			printInorder(root.right);
		}
	}

	private void printPostorder(BinaryTreeNode<T> root) {
		if (root != null) {
			printInorder(root.left);
			printInorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	private void printLevelOrder(BinaryTreeNode<T> root) {
		if (root != null) {
			Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> node = queue.poll();
				System.out.print(node.data + " ");
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
		}
	}

	private BinaryTreeNode<T> getDeepestNode() {
		BinaryTreeNode<T> presentNode = null;
		if(root != null) {
			Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				presentNode = queue.poll();
				if(presentNode.left != null)
					queue.add(presentNode.left);
				if(presentNode.right != null)
					queue.add(presentNode.right);
			}
		}
		return presentNode;
	}

	private T deleteDeepestNode() {
		T data = null;
		if(root != null) {
			Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			queue.add(root);
			BinaryTreeNode<T> presentNode = null, previousNode;
			while(! queue.isEmpty()) {
				previousNode = presentNode;
				presentNode = queue.poll();
				if(presentNode.left == null) {
          			if (null != previousNode) {
            			data = previousNode.right.data;
            			previousNode.right = null;
          			}
          			return data;
				}
				else if(presentNode.right == null) {
					if (null != previousNode) {
						data = presentNode.left.data;
						presentNode.left = null;
					}
					return data;
				}
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}
		System.out.println("Nothing to Delete");
		return null;
	}

	private void deleteNode(T num) {
		deleteNodeFromTree(root, num);
	}

	private void deleteNodeFromTree(BinaryTreeNode<T> root, T num) {
		BinaryTreeNode<T> presentNode;
		if(root != null) {
			Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			queue.add(root);
			while(! queue.isEmpty()) {
				presentNode = queue.poll();
				if(presentNode.data == num) {
					presentNode.data = getDeepestNode().data;
					deleteDeepestNode();
					break;
				}
				if(presentNode.left != null)
					queue.add(presentNode.left);
				if(presentNode.right != null)
					queue.add(presentNode.right);
			}
		}
	}

	private void deleteTree() {
		root = null;
	}

	public static void main(String[] args) {
		Random num = new Random();
		int deleteNum = num.nextInt(99);
		BinaryTreeMain<Integer> binaryTreeMain = new BinaryTreeMain<>();
		System.out.print("Input data for Linked List  ");

		for (int i = 0; i <= 9; i++) {
			int n = num.nextInt(99);
			// System.out.print(n + " ");
			if(i == 6)
				binaryTreeMain.insert(deleteNum);
			binaryTreeMain.insert(n);
		}
		System.out.println();
		binaryTreeMain.print();

		System.out.println("Delete number "+ deleteNum);
		binaryTreeMain.deleteNode(deleteNum);
		binaryTreeMain.print();

		System.out.println("Deepest node " + binaryTreeMain.getDeepestNode().data);

		System.out.println("Deleting deepest node " + binaryTreeMain.deleteDeepestNode());
		binaryTreeMain.print();

		binaryTreeMain.deleteTree();

	}
}
