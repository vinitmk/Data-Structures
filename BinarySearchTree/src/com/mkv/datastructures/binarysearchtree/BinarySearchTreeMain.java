package com.mkv.datastructures.binarysearchtree;

import java.util.Scanner;

import com.mkv.datastructures.common.IOHandler;

public class BinarySearchTreeMain implements IOHandler<Integer> {

	private BinarySearchTreeNode<Integer> root;

	@Override
	public void print() {
		printInorder(root);
	}

	private void printInorder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
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

	}
}
