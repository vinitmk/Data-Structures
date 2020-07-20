package com.mkv.datastructures.binarysearchtree;

import java.util.Scanner;

import com.mkv.datastructures.common.IOHandler;

public class BinarySearchTreeMain implements IOHandler<Integer> {

	private BinarySearchTreeNode<Integer> root;

	@Override
	public void print() {
		System.out.println("Inorder traversal ");
		printInorder(root);
		System.out.println("\nPreorder traversal ");
		printPreoder(root);
		System.out.println("\nPostorder traversal ");
		printPostOrder(root);
	}

	private void printPreoder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			System.out.print(root.data + "\t");
			printPreoder(root.left);
			printPreoder(root.right);
		}
	}

	private void printPostOrder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			printPreoder(root.left);
			printPreoder(root.right);
			System.out.print(root.data + "\t");
		}
	}

	private void printInorder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			printInorder(root.left);
			System.out.print(root.data + "\t");
			printInorder(root.right);
		}
	}

	public void heightOfTree(){
		int heightOfBinarySearchTree = calculateHeight(root);
		System.out.print("\nHeight of Binary Search Tree is " + heightOfBinarySearchTree);
	}

	private int calculateHeight(BinarySearchTreeNode<Integer> root) {
		int rightSubTreeHeight, leftSubTreeHeight;
		if(root == null)
			return 0;
		else {
			leftSubTreeHeight = calculateHeight(root.left);
			// System.out.println(" root leftSubTreeHeight "+root.data+"\t"+leftSubTreeHeight);
			rightSubTreeHeight = calculateHeight(root.right);
			// System.out.println(" root rightSubTreeHeight "+root.data+"\t"+rightSubTreeHeight);
			return leftSubTreeHeight > rightSubTreeHeight ? ++leftSubTreeHeight : ++rightSubTreeHeight;
		}
	}

	@Override
	public void createDataStructure(Integer data) {
		root = createDataStructure(root, data);
	}

	private BinarySearchTreeNode<Integer> createDataStructure(BinarySearchTreeNode<Integer> root, Integer data) {
		if(null == root)
			return new BinarySearchTreeNode<>(data);
		else if (root.data > data)
			root.left = createDataStructure(root.left, data);
		else
			root.right = createDataStructure(root.right, data);
		return root;
	}

	public static void main(String[] args){
		int data;
		BinarySearchTreeMain binarySearchTreeMain = new BinarySearchTreeMain();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Input data for Linked List ");
		while(scanner.hasNext()){
			data = scanner.nextInt();
			binarySearchTreeMain.createDataStructure(data);
		}

		binarySearchTreeMain.print();
		binarySearchTreeMain.heightOfTree();

	}
}
