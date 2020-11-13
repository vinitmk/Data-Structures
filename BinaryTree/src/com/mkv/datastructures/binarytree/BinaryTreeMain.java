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

	public static void main(String[] args) {
		Random num = new Random();
		BinaryTreeMain<Integer> binaryTreeMain = new BinaryTreeMain<>();
		System.out.println("Input data for Linked List ");

		for (int i = 0; i < 10; i++) {
			int n = num.nextInt(99);
			System.out.print(n + " ");

			binaryTreeMain.insert(n);
		}
		System.out.println();
		binaryTreeMain.print();
	}
}
